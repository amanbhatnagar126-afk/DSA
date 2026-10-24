class Solution {
    private final int[] DAYS = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveAliceDays = getDays(arriveAlice);
        int leaveAliceDays = getDays(leaveAlice);
        int arriveBobDays = getDays(arriveBob);
        int leaveBobDays = getDays(leaveBob);

        int overlapStart = Math.max(arriveAliceDays, arriveBobDays);
        int overlapEnd = Math.min(leaveAliceDays, leaveBobDays);

        return Math.max(0, overlapEnd - overlapStart + 1);
    }

    private int getDays(String date) {
        int month = 10 * (date.charAt(0) - '0') + (date.charAt(1) - '0');
        int day = 10 * (date.charAt(3) - '0') + (date.charAt(4) - '0');
        
        int totalDays = 0;
        for (int i = 1; i < month; i++) {
            totalDays += DAYS[i - 1];
        }
        return totalDays + day;
    }
}