import java.util.*;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 8;
    private int codelen = 5;
    private String Vcode;
    private String company = "drngpit.ac.in";
    private String name;

    // Sample array for search/sort demo
    private int[] demoArray = {5, 2, 9, 1, 7};

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Kindly ! Enter department for email creation dear " + this.firstName + " " + this.lastName);

        // dept
        this.department = setDepartment();
        System.out.println("Department:" + department);

        // pass
        this.password = randomPass(defaultPasswordLength);
        System.out.println("New Password :" + password);

        // clipping name as one
        this.name = firstName + lastName;

        // verification code
        this.Vcode = vcode(codelen);
        System.out.println("Your verification code : " + Vcode);

        // Binding
        email = name.toLowerCase() + "." + department + "@" + company;
        System.out.println("Official mail :" + email);

        
        runDSADemo();
    }

    private String setDepartment() {
        System.out.println("Enter the department Id\nSales : 1\nDevelopment : 2\nAccounting : 3");
        Scanner in = new Scanner(System.in);
        int dep = in.nextInt();
        if (dep == 1) {
            return "sales";
        } else if (dep == 2) {
            return "dev";
        } else if (dep == 3) {
            return "acc";
        }
        return "";
    }

    private String randomPass(int length) {
        String password = "ABCEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] pass = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * password.length());
            pass[i] = password.charAt(rand);
        }
        return new String(pass);
    }

    private String vcode(int codelen) {
        String samcode = "1234567890";
        char[] code = new char[codelen];
        for (int i = 0; i < codelen; i++) {
            int c = (int) (Math.random() * samcode.length());
            code[i] = samcode.charAt(c);
        }
        return new String(code);
    }

    // DSA DEMO
    private void runDSADemo() {
        System.out.println("\n=== DSA Features Demo ===");

        // Linear Search
        int key = 7;
        int index = DSAUtils.linearSearch(demoArray, key);
        System.out.println("Linear Search: Element " + key + " found at index " + index);

        // Binary Search (after sorting)
        Arrays.sort(demoArray);
        int bIndex = DSAUtils.binarySearch(demoArray, key, 0, demoArray.length - 1);
        System.out.println("Binary Search: Element " + key + " found at index " + bIndex);

        // Cyclic Sort
        int[] nums = {3, 5, 2, 1, 4};
        DSAUtils.cyclicSort(nums);
        System.out.println("Cyclic Sort Result: " + Arrays.toString(nums));

        // Recursion (factorial example)
        int n = 5;
        System.out.println("Recursion (Factorial of " + n + "): " + DSAUtils.factorial(n));
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getVcode() {
        return Vcode;
    }

    public String getDept(String dep) {
        if (dep.equals("dev")) {
            return "Developers";
        } else if (dep.equals("acc")) {
            return "Accounts";
        } else if (dep.equals("sales")) {
            return "Sales";
        }
        return "";
    }

    public String showInfo() {
        return "Name : " + name + "\nOfficial email : " + email + "\nDepartment : " + getDept(department);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        String fName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lName = sc.nextLine();

        Email em1 = new Email(fName, lName);

        System.out.println("\n=== Final Info ===");
        System.out.println(em1.showInfo());
    }
}


class DSAUtils {

    // Linear Search
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    // Binary Search (Recursive)
    public static int binarySearch(int[] arr, int key, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (arr[mid] == key) return mid;
        else if (arr[mid] > key) return binarySearch(arr, key, low, mid - 1);
        else return binarySearch(arr, key, mid + 1, high);
    }

    // Cyclic Sort
    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }
    }

    // Factorial
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
