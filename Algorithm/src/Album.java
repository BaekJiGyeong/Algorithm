import java.util.*;

public class Album {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "kpop", "pop"};
        int[] plays = {500, 600, 500, 10000, 2500};
        int[] result = solution(genres, plays);
        System.out.println(result);
    }

    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        HashMap<String, LinkedList<Music>> map = new HashMap<>();
        HashMap<String, Integer> totalPlays = new HashMap<>();

        int total = 0;

        for(int i=0; i<genres.length; i++){
            Music m = new Music(i, plays[i]);
            if(map.containsKey(genres[i])){
                map.get(genres[i]).push(m);
                total = totalPlays.get(genres[i])+plays[i];
                totalPlays.put(genres[i],total);
            }
            else {
                LinkedList<Music> lm = new LinkedList<>();
                lm.push(m);
                map.put(genres[i],lm);
                totalPlays.put(genres[i],plays[i]);
            }
        }

        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(totalPlays.entrySet());

        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        Iterator<Music> musics ;
        LinkedList<Music> musicList ;
        int idx;
        for(Map.Entry<String, Integer> e : list_entries){
            idx = 0;
            musicList = map.get(e.getKey());
            Collections.sort(musicList);
            musics = musicList.iterator();
            while(musics.hasNext()){
                idx++;
                answer.add(musics.next().getNum());
                if(idx==2) break;
            }
        }
        int[] array = answer.stream().mapToInt(i->i).toArray();


        return array;
    }
}

class Music implements Comparable<Music>{
    private int num;
    private int plays;

    public Music(int num, int plays){
        this.num = num;
        this.plays = plays;
    }

    public int getNum(){
        return this.num;
    }

    @Override
    public int compareTo(Music o) {
        if(o.plays==this.plays){
            return this.num-o.num;
        }
        return o.plays-this.plays;
    }
}