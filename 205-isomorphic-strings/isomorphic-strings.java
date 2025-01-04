class Solution {
    public boolean isIsomorphic(String s, String t) {
        //if the length of two stings are not same definitely they are not isomorphic
        if(s.length()!=t.length()){
            return false;
        }
        //creating HashMaP
        Map<Character , Character> charMappingMap = new HashMap<>();
        for(int i =0;i<s.length();i++){
           char original =s.charAt(i);
            char replacement =t.charAt(i);
              // if my map already have my iterting key or not ?
            if(!charMappingMap.containsKey(original)){
                   // if map contains replacement value or not ? (2nd  col of Hashmapp)
                if(!charMappingMap.containsValue(replacement))
                charMappingMap.put(original , replacement);
                else
                return false;
            }
            else{ 
                // if first col value already taken or not ?
                char mappedCharacter = charMappingMap.get(original);
                if( mappedCharacter!= replacement){
                    return false;
                }
            }
        }
        return true;
    }
}