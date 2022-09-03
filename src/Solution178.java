public class Solution178 {
    String SQL = "select score, dense_rank() over (order by score desc) as 'rank' from scores;";
}
