import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        File file = new File("AdventureTime.txt");

        int challengeOneAnswer = challengeOne("inputOneTwo.txt");
        int challengeTwoAnswer = challengeTwo("inputOneTwo.txt");
        int challengeThreeAnswer = challengeThree("inputThreeFour.txt");
        int challengeFourAnswer = challengeFour("inputThreeFour.txt");

        writeFileAllAnswers("AdventureTime.txt", challengeOneAnswer, challengeTwoAnswer, challengeThreeAnswer, challengeFourAnswer);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] radar = readFile("inputOneTwo.txt");
        int count = 0;
        for (int i = 1; i < radar.length; i++) {
            if (radar[i] > radar[i-1]) {
                count++;
            }
        }
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] radar = readFileTwo("inputOneTwo.txt");
        int count = 0;
        for (int i = 1; i < radar.length; i++) {
            if (radar[i] > radar[i-1]) {
                count++;
            }
        }
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] instructions = readFileThree("inputThreeFour.txt");
        int x = 0;
        int y = 0;
        for (int i = 0; i < instructions.length; i++) {
            String[] currentInstruction = instructions[i].split(" ");
            String currentDirection = currentInstruction[0];
            int currentDistance = Integer.parseInt(currentInstruction[1]);
            if (currentDirection.equals("forward")) {
                x += currentDistance;
            }
            else if (currentDirection.equals("up")) {
                y += currentDistance;
            }
            else {
                y -= currentDistance;
            }
        }
        return x*y;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String[] instructions = readFileThree("inputThreeFour.txt");
        int x = 0;
        int y = 0;
        int aim = 0;
        for (int i = 0; i < instructions.length; i++) {
            String[] currentInstruction = instructions[i].split(" ");
            String currentDirection = currentInstruction[0];
            int currentDistance = Integer.parseInt(currentInstruction[1]);
            if (currentDirection.equals("forward")) {
                x += currentDistance + aim;
                y += currentDistance * aim;
            }
            else if (currentDirection.equals("up")) {
                aim += currentDistance;
            }
            else {
                aim -= currentDistance;
            }
        }
        return x*y;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static int[] readFileTwo(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index] = scanner.nextInt();
            if (scanner.hasNextLine()) {
                data[index++] += scanner.nextInt();
            }
            if (scanner.hasNextLine()) {
                data[index++] += scanner.nextInt();
            }
        }
        scanner.close();
        return data;
    }

    private static String[] readFileThree(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}