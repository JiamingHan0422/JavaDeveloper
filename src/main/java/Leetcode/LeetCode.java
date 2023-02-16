package Leetcode;

import java.util.*;
import java.util.regex.Pattern;

import static java.lang.Long.MAX_VALUE;
import static java.lang.Long.parseLong;

public class LeetCode {

    // compx O (log n) * compx O (log m)
    public static boolean searchmsatrix(int[][] matrix, int target) {
            // compx O (log m)
            for (int i = 0; i < matrix.length; i++ ){
                // bounded the first & last column and compare it with target , then binary search the current row.
                if(target >= matrix[i][0] && target <= matrix[i][matrix[i].length-1] ){
                    return search (matrix[i], target);
                }
            }
            return false;
    }
    // compx O (log n)
    private static boolean search(int[] nums, int target) {
            int low=0;
            int high= nums.length-1;
            int mid;
            while(low <= high){
                // every time find new mid
                mid = low + (high-low)/2;

                if(nums[mid]==target)
                    return true;

                    // target may be in right half
                else if (nums[mid]<target)
                    low= mid+1;

                    // target may be in left half
                else if (nums[mid]> target)
                    high= mid-1;
            }
            return false;
        }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr ={-1,-1};
        for (int i=0; i < nums.length ; i++){
            for(int j= i+1; j <nums.length; j++ ){
                if( nums[i]+ nums[j] == target){
                    arr [0] = i;
                    arr [1] = j;
                }
            }
        }
        return arr;
    }
    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;

        int temp=x, sum=0;
        while(x!=0){
            sum=(sum*10)+(x%10);
            x=x/10;
        }
        return (temp==sum);
    }

    public static int[] removeDuplicates(int[] nums) {
        for(int i=0; i < nums.length-1; i++){
            if (nums[i] == nums[i+1])
                nums[i] = -1;
        }

        int[] arr = new int[nums.length]; int count =0;
        for(int i=0; i < nums.length; i++){
            if (nums[i] == -1){
                continue;
            }
            else{
                arr[i] = nums[i];
                count ++;
            }
        }
        return arr;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max =0, k = 0;
        int low =0, high =1000;

        for (int i = 0; i < piles.length; i++) {
            if(max < piles[i] )
                max = piles[i];
        }

        if (piles.length == h)
            return max;

        else if (piles.length < h){
            while (low <= high){
                //binary search expect Hour
                int mid = (low + high )/2;
                int expHour = getHour(piles,mid);

                //  speed up
                if (expHour > h)
                    low = mid +1;

                //  speed down
                if(expHour <= h)
                    high = mid -1;
            }
        }
        return k = low;
    }
    private static int getHour(int[] piles, int mid){
        int res = 0;

        for (int i = 0; i < piles.length; i++) {
            // sum each of piles
            res += piles[i]/mid;
            // if has reminder round up
            if(piles[i] % mid >0)
                res ++;
        }
        return res;
    }

    public static int findMin(int[] nums) {
        int Countrotated = 1, min = 0;
        for (int i = 0; i < nums.length -1; i++) {
            if(nums[i]<nums[i+1]){
                Countrotated++;
                System.out.println(Countrotated);
            }
            else{
                min = nums[i+1];
                break;
            }
        }

        if (Countrotated == nums.length)
            min = nums[0];
        return min;
    }

    public int searchLogn(int[] nums, int target) {

            int orignalStart = 0;

            // Step 1: Find Orignal Starting point: the min number before rotated.
            int start = 0;
            int end = nums.length-1;
            while(start < end){

                int mid = (start+end)/2;
                // if mid point is not the end index and mid number is greater
                // than the following number like {4,5,6,7,0,1,2} mid =7 mid+1 =0
                // base function 1
                if(mid+1 <= nums.length && nums[mid] > nums[mid+1]){
                    //set the orignal Start index at right half {0,1,2} like 0
                    orignalStart =  mid+1;
                    break;
                }
                // else if mid still in the left bound and the order is still rising
                // like {4,5,6,7,0,1,2} mid is 6, we set the orignal Start index at mid  like 6
                // base function 2
                else if(mid > 0 && nums[mid-1] > nums[mid]){
                    orignalStart =  mid;
                    break;
                }

                // else if mid greater the end index (right bound), we set the start point at right half
                // like {4,5,6,7,0,1,2} mid is 6, strat at 7
                else if(nums[mid] >  nums[nums.length-1]){
                    start = mid + 1;
                }
                // otherwise we set the end point at left half
                else {
                    end = mid - 1;
                }
            }

            // Step 2: Find the given target
            start = 0;
            end = nums.length-1;
            while(start <= end){

                int mid = (start+end)/2;
                //like {4,5,6,7,0,1,2} mid is index 0 value 4, realMid is (0+ 4) % 7 = 4
                int realMid = (mid + orignalStart) % nums.length;

                // if we hit the target, return it
                // base case
                if(target == nums[realMid]){
                    return realMid;
                }
                //else if the value of realMid (like 1 or 2) > traget (like 0), we set bound to  left half
                else if(nums[realMid] > target){
                    end = mid - 1;
                }
                //otherwise, the value of realMid < traget, we set bound to right half
                else {
                    start = mid + 1;
                }
            }
            return -1;
    }

    public static int HextoDec (String input ){
        int count = 0;
        for(int i=0; i < input.length()-2; i++){
            // 16进制的字母
            char tc = input.charAt(i+2);
            int t = 0;

            if(tc>='0' && tc<='9')
                t = tc - '0';
            else if(tc>='A' && tc<='F')
                t = tc - 'A' + 10;
            else if(tc>='a' && tc<='f')
                t = tc - 'a' +10;

            count += t * Math.pow(16, input.length()-i-3);
        }
        System.out.println(count);
        return count;
    }

    public static void checkPrime (){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            for (int i = 2; i <= Math.sqrt(num); ++i){
                while(num % i ==0){
                    System.out.print(i + " ");
                    num /=  i;
                }
            }
            System.out.println(num == 1 ? "": num+" ");
        }
    }

    public static void countStr(String str){
        char[] chArr = str.toCharArray();
        TreeMap<Character,Integer> tms = new TreeMap<Character,Integer>();
        for (int i = 0; i < chArr.length; i++) {
            Integer val = tms.get(chArr[i]);
            tms.put(chArr[i],val);
        }
        Set<Map.Entry<Character,Integer>> ets = tms.entrySet();
        Iterator<Map.Entry<Character,Integer>> its = ets.iterator();
        int count =0;
        while (its.hasNext()){
            Map.Entry<Character,Integer> ety = its.next();
            Character c = ety.getKey();
            count++;
        }

//        Iterator<Character> itss = tms.keySet().iterator();
//        while(itss.hasNext()){
//            Character key = itss.next();
//            Integer val = tms.get(key);
//        }
//
//        Iterator<Map.Entry<Character,Integer>> its = tms.entrySet().iterator();
//        while(its.hasNext()){
//            Map.Entry<Character,Integer> ety = its.next();
//            ety.getKey();
//            ety.getValue();
//        }

        System.out.println(count);
    }

    public static void Direction (String str){
        String[] strArr = str.split(";");
        HashMap<Character, Integer> hms = new HashMap<Character, Integer>();

        int countA = 0, countW = 0, countS = 0, countD = 0;
        for (int i = 0; i < strArr.length; i++) {

            if(!strArr[i].matches("[WASD][0-9]{1,2}"))
                continue;
            Integer val = Integer.valueOf(strArr[i].substring(1));

            if(strArr[i].charAt(0) == 'A'){
                countA += val;
                hms.put(strArr[i].charAt(0),countA);
            }
            if(strArr[i].charAt(0) == 'W'){
                countW += val;
                hms.put(strArr[i].charAt(0),countW);
            }
            if(strArr[i].charAt(0) == 'S'){
                countS += val;
                hms.put(strArr[i].charAt(0),countS);
            }
            if(strArr[i].charAt(0) == 'D'){
                countD += val;
                hms.put(strArr[i].charAt(0),countD);
            }

        }

        Set<Map.Entry<Character,Integer>> entSet = hms.entrySet();
        Iterator<Map.Entry<Character,Integer>> itEs = entSet.iterator();
        int x =0, y =0;
        while (itEs.hasNext()){
            Map.Entry<Character,Integer> mp = itEs.next();
            Character c = mp.getKey();
            Integer i = mp.getValue();
            if (c == 'A')
                x = x - i;
            if (c == 'D')
                x = x + i;
            if (c == 'W')
                y = y + i;
            if (c == 'S')
                y = y - i;
        }
        System.out.println(hms);
        System.out.println(x+","+y);
    }

    // 递归校验是否有重复子串
    private static boolean getString(String str, int l, int r) {
        // 两个base case
        if (r >= str.length())
            return false;
        //余下的字符串里是否包含选行的substring里的两个子字符串 substring包头不包尾所以从（0，3）开始
        if (str.substring(r).contains(str.substring(l, r)))
            return true;

        return getString(str,l+1,r+1);
    }
    // 检查是否满足正则
    private static boolean getMatch(String str){
        int count = 0;
        // Pattern类用于创建一个正则表达式
        // 通过两个静态方法创建：compile(String regex)和 compile(String regex,int flags)， flags 是可选模式 如忽略大小写等
        //它还有两个根据匹配模式拆分输入序列的方法 split(CharSequence input)
        Pattern p1 = Pattern.compile("[A-Z]");
        // matches()用于全字符串匹配，lookingAt()从字符串最开头开始匹配满足的子串，find()可以对任意位置字符串匹配, start()为起始查找索引值
        if(p1.matcher(str).find()){
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if(p2.matcher(str).find()){
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if(p3.matcher(str).find()){
            count++;
        }
        //[^a-z A-Z 0-9] 非字母 非数字
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if(p4.matcher(str).find()){
            count++;
        }
        if(count >= 3)
            return false;
        else
            return true;

    }

    public static void removeMinEle(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] chArr = str.toCharArray();
        HashMap<Character, Integer> hmtt = new HashMap<Character, Integer>();
        int count = 0;
        for (int i = 0; i < chArr.length; i++) {
            Integer val = hmtt.get(chArr[i]);
            if (val != null)
                count = val;
            count++;
            hmtt.put(chArr[i], count);
            count = 0;
        }

        Iterator<Character> itys = hmtt.keySet().iterator();
        int min = 999;

        while (itys.hasNext()) {
            Character key = itys.next();
            Integer val = hmtt.get(key);
            if (min > val)
                min = val;
        }

        for (int i = 0; i < chArr.length; i++) {
            // 由value找key
            if (! hmtt.get(chArr[i]).equals(min))
                System.out.print(chArr[i]);
        }
    }

    // 数学常识 ip转来的数在十进制中（组数n，ip当前值x）  是 X * 256^n
    public static void ipToDec(String str){
        String[] strArr = str.split("\\.");
        long sum =0;
        for (int i = 0; i < strArr.length; i++) {
            sum +=  parseLong(strArr[i]) * Math.pow(256, 3-i);
            System.out.println(sum);
        }
    }

    public static void DecToIp(long lon) {
        String[] ans = new String[4];
        for (int i = 3; i >= 0; i--) {
            ans[i] = Long.toString(lon % 256);
            lon = lon / 256;
        }
    }

    public int findLengthOfLCIS2(int[] nums) {
        if(nums.length==0)
            return 0;
        int maxLength = 1, count =1;
        for(int i =0; i < nums.length-1; i++){
            if(nums[i] < nums[i+1]){
                count ++;
                if(maxLength <= count)
                    maxLength = count;
            }
            else
                count = 1;
        }
        return maxLength;
    }

    public static int longestBeautifulSubstring(String word) {
    int maxLength = 0, count = 0, vowelCount = 0;
	for(int i=0;i<word.length();i++) {
        // 如果前一个word比后一个word大 一切推翻从来
        if(i!=0 && word.charAt(i) < word.charAt(i-1)) {
            vowelCount = 0;
            count = 0;
        }
        count++;
        if(i==0 || word.charAt(i) != word.charAt(i-1))
            vowelCount++;

        //如果存在元音够5个，满足条件的话就对比 最大值
        if(vowelCount == 5)
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }

    public static void matrix(){
        Scanner in = new Scanner(System.in);
        int numMatrix = in.nextInt();
        int[][]  arrMatrix = new int[numMatrix][2];
        for(int i =0; i< numMatrix; i++){
            arrMatrix[i][0]  = in.nextInt();
            arrMatrix[i][1]  = in.nextInt();
        }
        int ans = 0;
        String str = in.next();
        char[] chars = str.toCharArray();
        Stack<Integer> stk = new Stack<>();
        for(int j=0;j<chars.length;j++){
            if(chars[j]=='('){
                continue;
            }
            else if(chars[j]==')'){
                int x1 = stk.pop();
                int y1 = stk.pop();
                int x2 = stk.pop();
                int y2 = stk.pop();
                if (y1 == x2)
                    ans += numOperation(x1,y1,y2);
                // 把相乘后的新矩阵 注意先尾再头放进去在push回去 准备和下一任矩阵相乘
                stk.push(y2);
                stk.push(x1);
            }
            else if (chars[j] >= 'A' && chars[j] <= 'Z'){
                stk.push(arrMatrix[chars[j]-65][0]);
                stk.push(arrMatrix[chars[j]-65][1]);
            }
        }
        System.out.println(ans);
    }
    private static int numOperation(int l, int common, int r){
        int numOperation = l*r *common;
        return numOperation;
    }

    public static void mergeTable( ){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        TreeMap<Integer, Integer> myTm = new TreeMap<Integer, Integer>();

        for (int i = 0; i < num; i++) {
            Integer key = in.nextInt();
            Integer val = in.nextInt();
            if (myTm.containsKey(key))
                myTm.put(key, myTm.get(key) + val);
            else
                myTm.put(key,val);
        }

        Iterator<Integer> myItes = myTm.keySet().iterator();
        while (myItes.hasNext()){
            Integer keys = myItes.next();
            Integer vals = myTm.get(keys);
            System.out.println(keys+ " " +vals);
        }
    }
    public static void stringSort( ) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String[] strArr = new String[num];
        for (int i = 0; i < num; i++)
            strArr[i] = in.next();
        Arrays.sort(strArr);
        for (int i = 0; i < strArr.length; i++)
            System.out.println(strArr[i]);
    }

    public static void brotherWords( ) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            List<String> dataset = new ArrayList<>();

            for (int i = 0; i < num; i++) {
                dataset.add(in.next());
            }
            Collections.sort(dataset);
            String target = in.next(), ans = "";
            char[] targetArr = target.toCharArray();
            Arrays.sort(targetArr);
            int count = 0;
            int k = in.nextInt();
            //排除掉dataset中不同长度 或与target相同的词
            for (String setEle : dataset) {
                if (setEle.equals(target) || setEle.length() != target.length())
                    continue;
                char[] setEleChar = setEle.toCharArray();
                Arrays.sort(setEleChar);
                //筛选完之后 对比两个升序数组是否相等，若相等必然为兄弟单词，count++，
                if (Arrays.equals(targetArr, setEleChar))
                    count++;
                // 然后取出输入中所要的index 和对应的单词
                if (count == k)
                    ans = setEle;
            }
            System.out.println(count);
            System.out.println(ans);
        }
    }

    public static void gradeUp() {
    Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            TreeMap<String, Integer> tmms = new TreeMap<String, Integer>(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    return 0;
                }
            });


            int num = in.nextInt();
            int sortWay = in.nextInt();
            for (int i = 0; i < num; i++)
                tmms.put(in.next(), in.nextInt());
            Iterator<String> itses = tmms.keySet().iterator();
                if (sortWay ==1)

                while (itses.hasNext()) {
                    String key = itses.next();
                    Integer val = tmms.get(key);
                    System.out.println(key + " " + val);
                }
        }
    }

    public static void gradeUp2() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            int flag = in.nextInt();
            Student[] stu = new Student[num];

            for (int i = 0; i < num; i++)
                stu[i] = new Student(in.next(), in.nextInt());
            sort(stu, flag);
            for (Student student : stu) {
                System.out.println(student.name + " " + student.score);
            }
        }
    }
    private static void sort(Student[] stu, int flag){
        if(flag == 1){
            Arrays.sort(stu, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return s1.score - s2.score;
                }
            });
        }

        if(flag == 0){
            Arrays.sort(stu, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return s2.score - s1.score;
                }
            });
        }
    }
    
    private static void LCS(){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String firstStr = in.next();
            String secondStr = in.next();

            if(firstStr.length() > secondStr.length() ){
                String temp = firstStr;
                firstStr = secondStr;
                secondStr = temp;
            }
            int m = firstStr.length(), n = secondStr.length();

            int max =0, index =0;
            int[][] lcs = new int[m][n];
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if(firstStr.charAt(i-1) == secondStr.charAt(j-1)){
                        lcs[i][j] = lcs[i-1][j-1]+1;
                        if(lcs[i][j] > max){
                            max = lcs[i][j];
                            index = i;
                        }
                    }
                }
            }
            //substring包头不包尾所以从（1，4）开始
            System.out.println(firstStr.substring(index -max, index));
        }
    }
    private static void FaMa(){
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int num =in.nextInt();
            int[] arrType = new int[num];
            int[] arrNum = new int[num];
            for(int i =0; i< arrType.length; i++){
                arrType[i]= in.nextInt();
            }
            int count =0;
            for(int i =0; i< arrNum.length; i++){
                arrNum[i]= in.nextInt();
                count += arrNum[i];
            }

            HashMap<Integer,Integer> famaHm = new HashMap<Integer,Integer>();
            for (int i = 0; i < num; i++) {
                famaHm.put(arrType[i],arrNum[i]);
            }
            Iterator<Integer> FaMait = famaHm.keySet().iterator();
            int[] TotalArr = new int[count];
            Integer temp = 0;
            while(FaMait.hasNext()){
                Integer key = FaMait.next();
                Integer val = famaHm.get(key);
                for (int i = 0; i < val; i++) {
                    TotalArr[i + temp]= key;
                }
                temp += val;
            } // 将所有砝码打进数组

            int sumType = 1, sum =0;
            int[] sumArr = new int[8];
            int tempcount =0;
            for (int i = 0; i < TotalArr.length; i++) {
                for (int j = i; j < TotalArr.length; j++) {
                    sum += TotalArr[j];
                    sumArr[j+tempcount] = sum;
                }
                tempcount =  TotalArr.length -i;
                sum =0;
            }// 打出所有的排列组合

            for (int i = 0; i < sumArr.length; i++) {
                for (int j = i + 1; j < sumArr.length; j++) {
                    if (sumArr[i] != sumArr[j])
                        sumType++;
                }
            }
            System.out.println(sumType);
        }
    }

    private static int Container(int[] height){
//        int MaxVal =0, currVal=0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i+1; j < height.length; j++) {
//                currVal = Math.min(height[j],height[i]) * (j-i);
//                if(currVal > MaxVal)
//                    MaxVal = currVal;
//            }
//        }
//        System.out.println(MaxVal);

        int left = 0, right = height.length-1;
        int maxVal = -1;

        while(left < right) {
            //然后将当前的左右最高板相乘求出当前最大面积
            int highMin = Math.min(height[left], height[right]);
            int currVal = (right-left) * Math.min(height[left], height[right]);

            //然后将当前最大面积 与全局最大面积作比较
            if(maxVal < currVal)
                maxVal = currVal;

            // 如果 左边的大。说明左边找到最高板了
            if(height[left] > height[right]) {
                //执行while找右边最高板
                while(left < right && height[right] <= highMin)
                    right--;
            }
            // 同理 如果右边的大。说明右边找到最高板了
            else if(height[left] < height[right]) {
                //执行while找左边边最高板
                while(left < right && height[left] <= highMin)
                    left++;
            }

            //那就是说两边相等咯，那就左右两边一起向中间紧缩，直到一方出现最大。跳出此循环
            else {
                while(left < right) {
                    if(height[left] > highMin || height[right] > highMin)
                        break;
                    left++;
                    right--;
                }
            }
        }
        return maxVal;
    }

    private static int[] productExceptSelf(int[] nums) {
//        int [] answer= new int[nums.length];
//        int temp =1;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if( j != i) {
//                    temp *= nums[j];
//                }
//            }
//            answer[i] = temp;
//            temp =1;
//        }
//        return answer;

        int[] answer = new int[nums.length];
        int temp_left = 1, temp_right = 1;

        //第一个loop扫过去，a[0] =1, a[1] =1*1, a[2] =1*1*2, a[3] =1*1*2*3
        for (int i = 0; i < nums.length; i++) {
            answer[i] = temp_left;
            temp_left *= nums[i];
        }
        //

        //第二个loop扫过去，去掉第一个1* 它是temp。
        // a[3] =1*2*3 (不变，因为最后一个在第一遍loop已经完成), a[2] =1*2 * (4) 因为倒数第二个在第一遍loop时差最后一个,
        // a[1] =1*2 * (4*3) 因为倒数第三个在第一遍loop时差最后两个, a[3] =1 * (4*3*2) 因为第一个在第一遍loop时差除第一个以外所有
        for (int i = nums.length - 1; i > 0 ; i--) {
            temp_right *= nums[i];
            answer[i - 1] *= temp_right;
        }
        return answer;
    }

    private static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer>  ans = new ArrayList<>();
        int start = 1;
            getCombine(n,k,start,ans);
        return ansList;
    }

    private static void getCombine(int n, int k, int start,List<Integer> ans ){
        for (int i = start; i < n-k +1; i++) {
            ans.add(start);
            getCombine(n,k,start,ans);
            ans.remove(ans.size()-1);
        }
    }
    //1 8 6 2 5 4 8 3 7
    
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[10][10], column = new boolean[10][10], matrix = new boolean[10][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int c = board[i][j];
                if (c == '.')
                    continue;

                int u = c - '0';
                //matrix 被分为了9个区域，第一行是0 1 2，第二行是3 4 5.. 为了实现这一点。我们将(i / 3) * 3作为上下判定 (j / 3)作为左右判定
                int matrixIndex = (i / 3) * 3 + (j / 3);
                // 但凡row column matrix 三个2维数组中存在一个true 说明该数已经存在过 则判定为false
                if (row[i][u] || column[j][u] || matrix[matrixIndex][u])
                    return false;
                //扫描完这个数之后将他改为true
                // row[1][5] 表示比如第一行有5这个数，那么第一行就不允许再存在5了，不管这个5在数独的哪，反正第一横行不能再有5了。 有就是无效
                // column[3][5] 表示比如第3列有5这个数，那么第3列就不允许再存在5了，不管这个5在数独的哪，反正第3纵列不能再有5了。 有就是无效
                row[i][u] = column[j][u] = matrix[matrixIndex][u] = true;
            }
        }
        return true;
    }

    public static int trap(int[] height) {
        int sum = 0, pointer =0;
        Stack<Integer> stk = new Stack<>();

        while(pointer < height.length){
            while(!stk.empty() && height[pointer] > height[stk.peek()] ){
                int h = height[stk.peek()];
                stk.pop();
                if(stk.empty())
                    break;
                int length = pointer - stk.peek()-1;
                // pop 完之后上一个peek的高度和这次peek的高度差即本次要收集的水源的高度，而边长不变
                int minLevel = Math.min(height[pointer] , height[stk.peek()]) ;
                sum += length * (minLevel -h);
            }
            stk.push(pointer);
            pointer ++;
        }
        return sum;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
//        int[] arr = new int[temperatures.length];
//        for (int i = 0; i < temperatures.length-1; i++) {
//            if(temperatures[i] <= 100 && temperatures[i] >= 30){
//                for (int j = i+1; j < temperatures.length; j+=arr[j]) {
//                    if(temperatures[i] < temperatures[j]){
//                        arr[i] = j-i;
//                        break;
//                    }
//                    else if (arr[j] == 0) {
//                        arr[i] = 0;
//                        break;
//                    }
//                }
//            }
//        }
//        return arr;

         //j+= result[j] 是精髓，让函数倒过来跑 result【j】记录的值和上一个result对比
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 2; i >= 0; i--) {
            //如果上一个result[j] 比当前result[j]大，那么后边不用看 必然小直接跳过
            for (int j = i + 1; j < temperatures.length; j+= result[j]) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
                //因为i-- 会影响到 j=0的情况
                else if (result[j] == 0) {
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // BFS 先记录新鲜橘子数量，再把所有已经腐烂的橘子放入已访问队列，按FIFO顺序处理
        Queue<int[]> VisitedList = new LinkedList<>();
        int freshOrg =0, minTime =0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOrg ++;
                }
                //唯一不同就是别人访问的是元素，这题访问的是i和j这俩角标
                else if(grid[i][j] == 2){
//                    int[] RotOrgList = {i,j};
                    VisitedList.add(new int[] {i,j});
                }
            }
        }

        //当新鲜橘子数为0 or 队列为空的时候说明BFS已经遍历完毕，所以循环只在两者都不满足的情况下才继续 二者缺一不可
        while(freshOrg >0 && !VisitedList.isEmpty()){
            minTime ++;
            // 这块必须要initial VisitedList队列的size，因为VisitedList的大小之后会变
            int ns = VisitedList.size();
            for (int i = 0; i <ns; i++) {
                //将队列最先进来的pop出去
                int[] RotOrgList = VisitedList.remove();
                //记录元素信息
                int row = RotOrgList[0] ;
                int column = RotOrgList[1];
                //然后对比，如果是un visited把它改成visited， fresh --；然后把visited的元素放入已访问列表的队尾
                if(row -1>= 0 && grid[row-1][column] ==1 ){
                    grid[row-1][column] = 2;
                    freshOrg --;
                    VisitedList.add(new int[] {row-1, column});
                }
                if(row +1< m && grid[row+1][column] ==1 ){
                    grid[row+1][column] = 2;
                    freshOrg --;
                    VisitedList.add(new int[] {row+1, column});
                }
                if(column-1>= 0 && grid[row][column-1] ==1 ){
                    grid[row][column-1] = 2;
                    freshOrg --;
                    VisitedList.add(new int[] {row, column-1});
                }
                if(column+1< n && grid[row][column+1] ==1 ){
                    grid[row][column+1] = 2;
                    freshOrg --;
                    VisitedList.add(new int[] {row, column+1});
                }
            }
        }


        //最后判断是否有新鲜橘子， 如果有解BFS永远能找到最短路径。所以minTime必然最短
        if(freshOrg >0)
            return -1;
        else
            return minTime;
    }

    public static int countPrimes(int n) {
        if (n <= 2)
            return 0;
        int count =0;
        boolean[] flags = new boolean[n];
        for (int i = 2; i < n; i++) {
           if(isPrime(i))
               count++;
        }
        return count;
    }
    public static boolean isPrime(int i){
        for (int j = 2; j <= (int) Math.sqrt(i); j++) {
            if(i % j ==0)
                return false;
        }
        return true;
    }

    //埃拉托斯特尼筛法: 对于质数 p，所有大于p的p的倍数都是合数，根据该性质移除所有的合数
    public int AIcountPrimes(int n) {
        if (n <= 2)
            return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] =false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i)
                    isPrime[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                count++;
        }
        return count;
    }


    //线性筛选
    public int LinerarcountPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 0;
        List<Integer> primes = new ArrayList<Integer>();
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
                count++;
            }
            for (int prime : primes) {
                if (i * prime < n) {
                    isPrime[i * prime] = false;
                    if (i % prime == 0) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        //先建一个list集合，在这个集合中先建立一个空list，此时集合长度为1
        List<List<Integer>> setNum = new ArrayList<List<Integer>>();
        setNum.add(new ArrayList<Integer>());

        //然后遍历num数组中的所有元素
        for (int n : nums) {
            //此时集合setNum的size会随subSetNum list的加入不断递增
            int size = setNum.size();

            //循环一开始是0-1，然后0-2，然后0-3
            for (int i = 0; i < size; i++) {

                //其中0-1的时候建立新的sublist，且将list的长度初始化为setNum 第0个list的长度1,list 内为[ [] ]
                //其中0-2的时候建立新的sublist，且此sublist继承[ [] [1] ] 并全体加2变成[ [2] [1，2] ]
                //其中0-3的时候建立新的sublist，且此sublist继承[ [] [1] [2] [1，2] ] 并全体加2变成[ [3] [1，3] [2，3] [1，2, 3]]
                List<Integer> subSetNum = new ArrayList<Integer>(setNum.get(i));
                System.out.print(setNum.get(i) +" ");
                //此时 subSetNum存入nums的第一个元素1 list 为[1]
                //此时 subSetNum存入nums的第二个元素1 list 为[2]
                //此时 subSetNum存入nums的第二个元素1 list 为[3]
                subSetNum.add(n);
                //将subSetNum list 放入集合 此时集合为 [ [] [1] ]
                //将subSetNum list 放入集合 此时集合为 [ [] [1], [2] [1,2]]
                //将subSetNum list 放入集合 此时集合为 [ [] [1], [2] [1,2],  [3] [1，3] [2，3] [1，2, 3]]
                setNum.add(subSetNum);

            }
            System.out.println();
        }
        return setNum;
    }

    public static int findDuplicate(int[] nums) {
        //就像循环状态机一样，先让快慢指针在状态机上动起来
        int fast =0, slow =0;
        fast = nums[nums[fast]];
        slow = nums[slow];
        //当快与慢撞上时生成相遇点，这个相遇点说明快针已经走了慢针两倍了。但这不重要。重要的是它能推导出循环开始的重复点
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        //当相遇点与重复点相同时，说明 起点到循环点的距离与相遇点到循环点的距离相同。说明循环点找到了
        int criclePoint =0, meetPoint= slow;
        while(criclePoint != meetPoint){
            criclePoint = nums[criclePoint];
            meetPoint = nums[meetPoint];
        }
        return meetPoint;
    }

    public int coinChange(int[] coins, int amount) {
        // 自底向上的动态规划
        if(coins.length == 0)
            return -1;

        // changeSet[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] changeSet = new int[amount+1];
        changeSet[0] = 0;
        for(int i = 1; i <= amount;i++){
            // each time we initial the min
            int min = Integer.MAX_VALUE;

            for(int j = 0;j < coins.length;j++){
                // 在这个for循环中不停的update min 当j不大于余额，且它比回溯前的那一步min要小的时候
                if(i - coins[j] >= 0 && changeSet[i-coins[j]] < min)
                    min = changeSet[i-coins[j]] + 1;
            }
            changeSet[i] = min;
        }

        if(changeSet[amount] == Integer.MAX_VALUE)
            return  -1;
        else
            return changeSet[amount];
    }

    public ListNode detectCycle(ListNode head) {
        // inital at head 位置，即0点
        ListNode slow = head, fast = head;
        while(true) {
            //当快针无法继续时 返回null，说明没有重复。如果有重复快针不可能走完，它一定会和慢针相遇
            if (fast == null || fast.next == null)
                return null;

            //慢针走一格，快针走两格
            slow = slow.next;
            fast = fast.next.next;
            //当快慢针相遇时break
            if (slow == fast)
                break;
        }
        //然后慢针停留在相遇位置，将快针更新到起点。从相遇位置到第二次相遇位置所走的针数一定等于从起点到第二次相遇位置的针数
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    // 理解一下？？？
    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private static void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        //为避免重复，将走过的棋子变成0
        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
////        while (in.hasNext()) { // 注意 while 处理多个 case
////            boolean flag = true;
////            while (flag) {
////                String str = in.nextLine();
////
////                if(str.equals("nowcoder")){
////                    System.out.println("nowcoder");
////                    break;
////                }
////                String[] strArr = str.split(" ");
////                sortRise(strArr);
////                for (int j = 0; j < strArr.length ; j++) {
////                    System.out.print(strArr[j] + " ");
////                }
////            }
////        }
//        while (in.hasNextLine()) {
//            String[] words = in.nextLine().split(",");
//            Arrays.sort(words, (w1, w2) -> w1.compareTo(w2));
//            int wn = words.length;
//            for (int i = 0; i < wn - 1; i ++) {
//                System.out.print(words[i] + ',');
//            }
//            System.out.println(words[wn - 1]);
//        }
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println(numIslands(grid));
    }
//1 1 0 0 0
//1 1 0 0 0
//0 0 1 0 0
//0 0 0 1 1
    public static void StringDirectionary() {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
         // 5 cat dog category window cup  0    cat cup dog window cat
        String[] arr= new String[num];

         for (int j = 0; j < arr.length; j++) {
            arr[j] = in.next();
        }

        int flag = in.nextInt();

        if(flag == 0)
            sortRise(arr);
        else if (flag == 1)
            sortDown(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static String[] sortRise(String[] strings){
        Arrays.sort(strings, (v1,v2) -> (v1 + v2).compareTo((v2 + v1)));
        return strings;
    }

    private static String[] sortDown(String[] strings){
        Arrays.sort(strings, (o1,o2) -> (o2 + o1).compareTo((o1 + o2)));
        return strings;
    }

    public static int maxDepth(String s) {
        Stack<Character> stk = new Stack<>();
        char[] charArr = s.toCharArray();
        int depth =0, Max =0;
        for (int i = 0; i < charArr.length; i++) {
            if(charArr[i] == '('){
                stk.push('(');
                depth ++;
                Max= Math.max(depth,Max);
            }
            else if(charArr[i] == ')'){
                if(!stk.empty()){
                    stk.pop();
                    depth --;
                }
            }
        }
        if(stk.empty())
            return Max;
        else{
            System.out.println("InVPS");
            return 0;
        }
    }

    public static int BinarySearch(int[] arr, int target){
        int left = 0, right = arr.length-1, mid;

        while( left <= right){
            mid = (left + right)/2;
            if(arr[mid] == target )
                return mid;
            else if(arr[mid] > target)
                right = mid -1;
            else
                left = mid + 1;
        }
        return -1;
    }
}

class Student{
    String name;
    int score;

    public Student(String name,int score){
        this.name=name;
        this.score=score;
    }

    // copy
    public Student(Student s1){
        this.name = s1.name;
        this.score = s1.score;
    }

}

// y由 value 找key的方法
//    private static String getKey(TreeMap<String, Integer> map, Integer value){
//        String key = null;
//        //Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
//        for(String getKey: map.keySet()){
//            if(map.get(getKey).equals(value)){
//                key = getKey;
//            }
//        }
//        return key;
//        //这个key肯定是最后一个满足该条件的key.
//    }
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


