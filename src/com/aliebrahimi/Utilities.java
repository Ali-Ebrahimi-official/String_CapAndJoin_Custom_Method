package com.aliebrahimi;

public class Utilities {

    public static String stringCapAndJoin(String str) throws Exception{
        return StringCapAndJoin.capJoin(str);
    }

    private static class StringCapAndJoin {

        private static final StringBuilder stringBuilder = new StringBuilder();
        private static int index = 0;

        private static String capJoin(String str) throws Exception {

            if (str.isEmpty()) {
                throw new Exception ("Entered String is empty");
            } else if (str.isBlank()) {
                throw new Exception("Entered String is blank");
            }

            if (index == 0 && str.charAt(index) != ' '){
                stringBuilder.append(Character.toUpperCase(str.charAt(0)));
                index++;
            }


            // T = Empty
            // F = Full

            if (index < str.length() && index + 1 < str.length()){

                if (
                        (str.charAt(index) == ' ' && str.charAt(index + 1) == ' ')
                        ||                                                          // (T T) || (F T)
                        (str.charAt(index) != ' ' && str.charAt(index + 1) == ' '))
                {
                    index ++;
                    return capJoin(str);

                } else if (str.charAt(index) == ' ' && str.charAt(index + 1) != ' ') //  T F

                {
                    index ++;
                    stringBuilder.append(Character.toUpperCase(str.charAt(index)));
                    return capJoin(str);

                } else if (str.charAt(index) != ' ' && str.charAt(index + 1) != ' ') { // F F
                    index++;
                    stringBuilder.append(str.charAt(index));
                    return capJoin(str);

                }
            }

            return stringBuilder.toString();

        }
    }
}