public class DataPair{
    String strValue;
    int intValue;

    DataPair( String strValue  , int intValue){
        this.strValue = strValue;
        this.intValue = intValue;
    }
}

class TimeMap {

    private HashMap<String , List<DataPair>> hm;

    public TimeMap() {
        hm = new HashMap<String , List<DataPair>>();
    }

    public void set(String key, String value, int timestamp) {

        hm.putIfAbsent(key,new ArrayList<DataPair>());
        hm.get(key).add(new DataPair(value, timestamp));
    }

    public String get(String key, int timestamp) {

        if(!hm.containsKey(key)) return "";

        List<DataPair> dataPairValues = hm.get(key);
        int low = 0;
        int high = dataPairValues.size() -1;
        int mid = 0;
        String ans = "";

        while(low <= high ){
            mid = low + (high - low) /2;

            if (dataPairValues.get(mid).intValue <= timestamp){
                ans = dataPairValues.get(mid).strValue;
                low = mid + 1;
            }
            else high = mid - 1;

        }
        return ans;

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */