import java.util.Arrays;

// Class to represent a meeting with start and end time
class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting other) {
        return Integer.compare(this.end, other.end); // Sort by end time
    }
}

public class Nmeeting {

    public static int maxMeetings(Meeting[] meetings, int n) {
        Arrays.sort(meetings); // Sort meetings by end time

        int count = 1; // Always select the first meeting
        int lastEndTime = meetings[0].end;

        for (int i = 1; i < n; i++) {
            if (meetings[i].start > lastEndTime) {
                count++;
                lastEndTime = meetings[i].end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };
        int n = start.length;

        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        int result = maxMeetings(meetings, n);
        System.out.println("Maximum number of meetings that can be attended: " + result);
    }
}
