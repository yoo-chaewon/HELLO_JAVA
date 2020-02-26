import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> albumSum = new HashMap<>();
        HashMap<String, List<Song>> hashMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++){
            String curKey = genres[i];
            if (hashMap.containsKey(curKey)){
                List<Song> tmp = hashMap.get(curKey);
                tmp.add(new Song(i, plays[i]));
                hashMap.put(curKey, tmp);
                albumSum.put(curKey, albumSum.get(curKey) + plays[i]);
            }else {
                albumSum.put(curKey, plays[i]);
                List<Song> arr = new LinkedList<>();
                arr.add(new Song(i, plays[i]));
                hashMap.put(curKey, arr);
            }
        }

        LinkedList<String> keys = new LinkedList<>();
        keys.addAll(albumSum.keySet());
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return albumSum.get(o2)-albumSum.get(o1);
            }
        });

        for (String key : keys){
            Collections.sort(hashMap.get(key), new Comparator<Song>() {
                @Override
                public int compare(Song o1, Song o2) {
                    return o2.count - o1.count;
                }
            });
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (String key : keys){
            int size = Math.min(2, hashMap.get(key).size());
            for (int i = 0; i < size; i++){
                result.add(hashMap.get(key).get(i).num);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}

class Song{
    int num;
    int count;
    Song(int num, int count){
        this.num = num;
        this.count = count;
    }
}