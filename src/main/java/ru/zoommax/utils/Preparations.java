package ru.zoommax.utils;

/* open " = 0x0E60
* close " = 0x0E61
* separator , = 0x0E62
* separator : = 0x0E63
*/
class Preparations {
    public String replaceEnter(String json){
        return json.replace("\n", "").replace("\r", "");
    }

    public String replaceSpace(String s){
        s =  s.replace(": ", ":").replace(" :", ":").replace(", ", ",").replace(" ,", ",");
        return s.replaceAll("(?<=\\{)([\\s]{2,})", "")
                .replaceAll("(?<=\\[)([\\s]{2,})", "")
                .replaceAll("(?<=\\])([\\s]{2,})", "")
                .replaceAll("(?<=\\})([\\s]{2,})", "")
                .replaceAll("(?<=,)([\\s]{2,})(?=\")", "")
                .replaceAll("(?<=,)([\\s]{2,})(?=\\{)", "")
                .replaceAll("(?<=,)([\\s]{2,})(?=\\[)", "")
                .replaceAll("(?<=,)([\\s]{2,})(?=\\})", "")
                .replaceAll("(?<=,)([\\s]{2,})(?=\\])", "");
    }

    String replaceTags(String s, String r){
        return s.substring(1, s.lastIndexOf(r));
    }

    public String replaceColon(String json){
        char startQuote = ControlChars.STARTQUOTE.getCh();
        char endQuote = ControlChars.ENDQUOTE.getCh();
        char separator = ControlChars.COLON.getCh();
        boolean need = true;
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < json.length(); x++) {
            char j = json.charAt(x);
            if (j == startQuote) {
                need = false;
            }
            if (j == endQuote) {
                need = true;
            }
            if (need){
                if (j == ':'){
                    if (json.charAt(x-1) != '\\') {
                        sb.append(separator);
                    }else {
                        sb.append(':');
                    }
                }else {
                    sb.append(j);
                }
            }else {
                sb.append(j);
            }
        }
        return sb.toString();
    }

    public String replaceCommaInArray(String json){
        char separator = ControlChars.COMMAINARRAY.getCh();
        char arrayStart = '[';
        char endArray = ']';
        char startQuote = ControlChars.STARTQUOTE.getCh();
        char endQuote = ControlChars.ENDQUOTE.getCh();
        boolean need = false;
        boolean need2 = true;
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < json.length(); x++){
            char j = json.charAt(x);
            if (j == arrayStart){
                need = true;
            }
            if (j == startQuote){
                need2 = false;
            }
            if (j == endQuote){
                need2 = true;
            }
            if (j == endArray){
                need = false;
            }
            if (need&&need2){
                if (j == ',') {
                    sb.append(separator);
                }else {
                    sb.append(j);
                }
            }else {
                sb.append(j);
            }
        }
        return sb.toString();
    }

    public String replaceComma(String json){
        //replace comma to 0x0E62 where a comma is a pair separator
        char separator = ControlChars.COMMA.getCh();
        char startQuote = ControlChars.STARTQUOTE.getCh();
        char endQuote = ControlChars.ENDQUOTE.getCh();
        boolean need = true;
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < json.length(); x++){
            char j = json.charAt(x);
            if (j == startQuote){
                need = false;
            }
            if (j == endQuote){
                need = true;
            }
            if (need){
                if (j == ',') {
                    sb.append(separator);
                }else {
                    sb.append(j);
                }
            }else {
                sb.append(j);
            }
        }
        return sb.toString();
    }

    public String replaceQuotes(String json){
        //replace quote start and end quote to 0x0E60 and 0x0E61;
        char quoteStart = ControlChars.STARTQUOTE.getCh();
        char endQuote = ControlChars.ENDQUOTE.getCh();
        int need = 0;
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x<json.length(); x++) {
            if (json.charAt(x) == '"') {
                if (x>0) {
                    if (json.charAt(x - 1) != '\\'){
                        need++;
                    }
                }
            }

            if (json.charAt(x) == '"') {
                if (x>0) {
                    if (json.charAt(x - 1) != '\\'){
                        if (need%2 != 0){
                            sb.append(quoteStart);
                        }else {
                            sb.append(endQuote);
                        }
                    }else {
                        sb.deleteCharAt(x-1);
                        sb.append('"');
                    }
                }
            }else {
                sb.append(json.charAt(x));
            }
        }

        return sb.toString();
    }
}
