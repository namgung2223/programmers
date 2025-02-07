class Solution {
    public int[] solution(String[] wallpaper) {
        int firstRow = Integer.MAX_VALUE; // 최소 행을 찾기 위해 큰 값으로 설정
        int firstCol = Integer.MAX_VALUE; // 최소 열을 찾기 위해 큰 값으로 설정
        int lastRow = Integer.MIN_VALUE;  // 최대 행을 찾기 위해 작은 값으로 설정
        int lastCol = Integer.MIN_VALUE;  // 최대 열을 찾기 위해 작은 값으로 설정

        for (int i = 0; i < wallpaper.length; i++) {
            String locate = wallpaper[i];

            if (locate.contains("#")) {
                //"#"이 나오는 최소 행 찾기
                firstRow = Math.min(firstRow, i);
                //가장 왼쪽 "#"이 나오는 최소 열 찾기
                firstCol = Math.min(firstCol, locate.indexOf("#"));

                //마지막 "#"이 나온 행의 다음 값
                lastRow = Math.max(lastRow, i + 1);
                //가장 오른쪽 "#"이 나오는 최대 열 찾기
                lastCol = Math.max(lastCol, locate.lastIndexOf("#") + 1);
            }
        }

        return new int[]{firstRow, firstCol, lastRow, lastCol};
    }
}