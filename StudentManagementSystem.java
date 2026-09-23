import java.util.*;

class StudentManagementSystem {
	
	 // Batch status
    public static final int ENROLLMENTOPEN = 1;
    public static final int ENROLLMENTCLOSED = 0;
    
    
    // Batch data
    public static int[] batchNos  = { 105, 106, 107, 108, 109, 110 };
    public static int[] batchStatus  = { 0, 0, 0, 0, 1, 1 };

    public static String[] studentIDs = {
            "PR24105001", "PR24105002", "PR24105003", "PR24105004", "PR24105005",
            "PR24105006", "PR24105007", "PR24105008", "PR24105009", "PR24105010",
            "OR24105011", "OR24105012", "OR24105013", "OR24105014", "OR24105015",
            "PR24105016", "PR24105017", "PR24105018", "OR24105019", "OR24105020",
            "PR24105021", "PR24105022", "OR24105023", "OR24105024", "PR24105025",
            "PR24106001", "PR24106002", "PR24106003", "PR24106004", "PR24106005",
            "PR24106006", "PR24106007", "PR24106008", "PR24106009", "PR24106010",
            "OR24106011", "OR24106012", "OR24106013", "OR24106014", "OR24106015",
            "PR24106016", "PR24106017", "PR24106018", "OR24106019", "OR24106020",
            "PR24106021", "PR24106022", "OR24106023", "OR24106024", "PR24106025",
            "PR24107001", "PR24107002", "PR24107003", "PR24107004", "PR24107005",
            "PR24107006", "PR24107007", "PR24107008", "PR24107009", "PR24107010",
            "OR24107011", "OR24107012", "OR24107013", "OR24107014", "OR24107015",
            "PR24107016", "PR24107017", "PR24107018", "OR24107019", "OR24107020",
            "PR24107021", "PR24107022", "OR24107023", "OR24107024", "PR24107025",
            "PR24108001", "PR24108002", "PR24108003", "PR24108004", "PR24108005",
            "PR24108006", "PR24108007", "PR24108008", "PR24108009", "PR24108010",
            "OR24108011", "OR24108012", "OR24108013", "OR24108014", "OR24108015",
            "PR24108016", "PR24108017", "PR24108018", "OR24108019", "OR24108020",
            "PR24108021", "PR24108022", "OR24108023", "OR24108024", "PR24108025",
            "PR24109001", "PR24109002", "PR24109003", "PR24109004", "PR24109005",
            "PR24109006", "PR24109007", "PR24109008", "PR24109009", "PR24109010",
            "OR24109011", "OR24109012", "OR24109013", "OR24109014", "OR24109015",
            "PR24109016", "PR24109017", "PR24109018", "OR24109019", "OR24109020",
            "PR24109021", "PR24109022", "OR24109023", "OR24109024", "PR24109025",
            "PR24110001", "PR24110002", "PR24110003", "PR24110004", "PR24110005",
            "PR24110006", "PR24110007", "PR24110008", "PR24110009", "PR24110010",
            "OR24110011", "OR24110012", "OR24110013", "OR24110014", "OR24110015",
            "PR24110016", "PR24110017", "PR24110018", "OR24110019", "OR24110020",
            "PR24110021", "PR24110022", "OR24110023", "OR24110024", "PR24110025"
    };

    public static String[] NICs = {
            "199501012345", "199503153872", "199506202198", "199509102983", "199511258739",
            "199512303498", "199502183764", "199504223198", "199508153210", "199510293417",
            "199601102375", "199604182938", "199606243879", "199608142178", "199610312475",
            "199611173452", "199603293481", "199605083217", "199607232198", "199609192375",
            "199701212483", "199703132487", "199706253478", "199708083298", "199710243651",
            "199712152983", "199702182734", "199704293187", "199705142375", "199709083751",
            "199801032874", "199803232871", "199806193428", "199808013764", "199810242374",
            "199812302984", "199802152348", "199805213471", "199807172398", "199811283472",
            "199901122471", "199903052984", "199906213874", "199908093412", "199910273894",
            "199912153482", "199902202394", "199904163874", "199907293481", "199911083479",
            "200001112374", "200003143478", "200006293874", "200008103471", "200010252984",
            "200012043894", "200002193874", "200004212374", "200005183492", "200007153871",
            "200101232984", "200103083471", "200106273894", "200108123984", "200110043728",
            "200112213874", "200102253471", "200104103874", "200105293784", "200107202983",
            "200201013874", "200203253471", "200206143874", "200208083471", "200210293874",
            "200212183471", "200202103874", "200204123894", "200205283471", "200207153874",
            "200301093874", "200303283471", "200306153874", "200308123471", "200310083874",
            "200312243471", "200302273874", "200304203471", "200305123874", "200307213471",
            "200401153874", "200403123471", "200406293874", "200408083471", "200410213874",
            "200412153471", "200402203874", "200404273471", "200405143874", "200407183471",
            "200501023874", "200503193471", "200506153874", "200508213471", "200510083874",
            "200512293471", "200502123874", "200504153471", "200505283874", "200507173471",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200512345678", "199909876543", "199812346789", "200010203040", "200608789012",
            "200012345678", "199812345679", "199902345678", "199712345670", "200102345671",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200512345678", "199909876543", "199812346789", "200010203040", "200608789012",
            "200012345678", "199812345679", "199902345678", "199712345670", "200102345671",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678",
            "200203456782", "200305678901", "199601234567", "199511223344", "200412345678"
    };

    public static String[] studentNames = {
            "Gunawardena Weerasinghe", "Senanayake Silva", "Silva Kumara", "Kumara Herath", "Rathnayake Herath",
            "Wijesinghe Bandara", "Rajapaksha Herath", "Senanayake Karunaratne", "Karunaratne Jayasinghe", "Gunawardena Silva",
            "Weerasinghe Rajapaksha", "Silva Rathnayake", "Fernando Perera", "Kumara Abeysekera", "Ekanayake Rathnayake",
            "Herath Gunawardena", "Abeysekera Silva", "Weerasinghe Silva", "Jayasinghe Dias", "Bandara Rathnayake",
            "Silva Perera", "De Silva Dias", "Abeysekera Jayasinghe", "Rajapaksha Senanayake", "Kumara Karunaratne",
            "Silva Abeysekera", "Jayasinghe Bandara", "Rathnayake Kumara", "Weerasinghe Rajapaksha", "Senanayake Herath",
            "Perera Ekanayake", "Herath Jayasinghe", "Kumara Gunawardena", "Abeysekera Silva", "Dias Fernando",
            "Karunaratne Weerasinghe", "Ekanayake Bandara", "Rajapaksha Kumara", "Silva De Silva", "Gunawardena Rathnayake",
            "Bandara Karunaratne", "Fernando Perera", "De Silva Silva", "Rajapaksha Gunawardena", "Herath Weerasinghe",
            "Karunaratne Dias", "Jayasinghe Silva", "Senanayake Abeysekera", "Silva Jayasinghe", "Rathnayake Kumara",
            "Gunawardena Kumara", "Rajapaksha Silva", "Perera Jayasinghe", "Silva Ekanayake", "Dias Senanayake",
            "Herath Abeysekera", "Rathnayake Fernando", "Kumara Herath", "Weerasinghe Silva", "Senanayake Karunaratne",
            "Abeysekera Silva", "Bandara Gunawardena", "Karunaratne Weerasinghe", "Perera Herath", "Fernando Dias",
            "Weerasinghe Gunawardena", "Rathnayake Kumara", "Senanayake Fernando", "Silva Bandara", "Herath Rajapaksha",
            "Kumara Jayasinghe", "Abeysekera Perera", "Rathnayake Jayasinghe", "Kumara Weerasinghe", "Rajapaksha Ekanayake",
            "Fernando Rajapaksha", "Silva Gunawardena", "Perera Wijesinghe", "Herath Abeysekera", "Rajapaksha Ekanayake",
            "Karunaratne Silva", "Weerasinghe Fernando", "Silva Bandara", "Abeysekera Weerasinghe", "Kumara Karunaratne",
            "Dias Rajapaksha", "Herath Perera", "Rathnayake Gunawardena", "Ekanayake Jayasinghe", "Gunawardena Silva",
            "Rajapaksha Perera", "Karunaratne Jayasinghe", "Weerasinghe Abeysekera", "Rathnayake Fernando", "Kumara Herath",
            "Silva Weerasinghe", "Herath Karunaratne", "Abeysekera Silva", "Gunawardena Ekanayake", "Weerasinghe Kumara",
            "Weerasinghe Kumara", "Rajapaksha Abeysekera", "Gunawardena Perera", "Karunaratne Silva", "Herath Wijesinghe",
            "Rathnayake Ekanayake", "Silva Fernando", "Abeysekera Rajapaksha", "Fernando Bandara", "Perera Herath",
            "Weerasinghe Jayasinghe", "Silva Karunaratne", "Rathnayake Gunawardena", "Herath Kumara", "Abeysekera Silva",
            "Ekanayake Bandara", "Rajapaksha Fernando", "Gunawardena Weerasinghe", "Kumara Karunaratne", "Silva Dias",
            "Perera Weerasinghe", "Karunaratne Rajapaksha", "Jayasinghe Silva", "Rathnayake Perera", "Silva Ekanayake",
            "Silva Karunaratne", "Herath Fernando", "Kumara Jayasinghe", "Weerasinghe Perera", "Abeysekera Rajapaksha",
            "Rathnayake Karunaratne", "Ekanayake Bandara", "Gunawardena Perera", "Silva Wijesinghe", "Rajapaksha Jayasinghe",
            "Rathnayake Fernando", "Karunaratne Kumara", "Perera Silva", "Gunawardena Ekanayake", "Bandara Rajapaksha",
            "Silva Herath", "Rathnayake Weerasinghe", "Perera Gunawardena", "Herath Karunaratne", "Silva Rajapaksha",
            "Ekanayake Kumara", "Bandara Herath", "Weerasinghe Rajapaksha", "Karunaratne Abeysekera", "Perera Dias"
    };

    public static int[] PRFMarks = {
            85, 39, -1, 72, 44, 91, 60, 38, 95, 49,
            -1, 67, 23, 58, 88, 81, 73, 29, 62, -1,
            79, 53, 94, 47, 35, 93, 15, -1, 82, 45,
            88, 23, 79, 37, -1, 68, 100, 59, 29, 92,
            12, 77, 38, 66, 9, 84, 51, 32, -1, 97,
            95, -1, 63, 88, 32, 76, 97, 54, -1, 23,
            90, 35, 81, 61, 44, 67, 100, 17, 85, 29,
            70, 42, -1, 60, 86, 86, 57, 91, 35, -1,
            76, 48, 94, 23, 69, -1, 80, 55, 88, 32,
            100, 67, 43, -1, 90, 60, 77, 25, 71, 84,
            92, 68, 59, 85, 63, 76, 91, 70, 84, 63,
            72, 89, 45, 81, 77, 68, 63, 88, 75, 90,
            57, 79, 92, 62, 100, -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2, -2, -2, -2, -2, -2
    };

    public static int[] DBMSMarks = {
            66, 45, 93, 58, -1, 37, 88, 21, 79, 40,
            76, 54, -1, 69, 92, 25, 84, 33, 60, 71,
            59, -1, 98, 27, 48, 35, 91, 60, -1, 72,
            49, 26, 80, 14, 89, 67, -1, 31, 94, 53,
            78, 5, 90, 24, 86, 39, -1, 61, 73, 100,
            38, 91, -1, 74, 55, 82, 66, 49, 99, 13,
            80, 70, 93, 36, 59, 85, 47, 90, -1, 22,
            77, 34, 63, 100, 29, 79, 62, 87, -1, 54,
            46, 99, 39, 70, -1, 75, 83, 58, 92, 30,
            91, 40, 63, 95, 68, -1, 66, 21, 88, 37,
            67, 91, 85, 73, 70, 63, 76, 88, 55, 64,
            79, 80, 59, 92, 68, 100, 77, 83, 45, 62,
            66, 59, 78, 85, 56, -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
            -2, -2, -2, -2, -2, -2, -2, -2, -2, -2
    };

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
    

    public static void extendBatchArrays() {
        int[] tempBatchNos = new int[batchNos.length + 1];
        int[] tempBatchStatus = new int[batchStatus.length + 1];

        for (int i = 0; i < batchNos.length; i++) {
            tempBatchNos[i] = batchNos[i];
            tempBatchStatus[i] = batchStatus[i];
        }

        batchNos = tempBatchNos;
        batchStatus = tempBatchStatus;
    }
    

    public static void extendArrays() {
        String[] tempStudentIDs = new String[studentIDs.length + 1];
        String[] tempStudentNames = new String[studentNames.length + 1];
        String[] tempNICs = new String[NICs.length + 1];
        int[] tempPRFMarks = new int[PRFMarks.length + 1];
        int[] tempDBMSMarks = new int[DBMSMarks.length + 1];

        for (int i = 0; i < studentIDs.length; i++) {
            tempStudentIDs[i] = studentIDs[i];
            tempStudentNames[i] = studentNames[i];
            tempNICs[i] = NICs[i];
            tempPRFMarks[i] = PRFMarks[i];
            tempDBMSMarks[i] = DBMSMarks[i];
        }

        studentIDs = tempStudentIDs;
        studentNames = tempStudentNames;
        NICs = tempNICs;
        PRFMarks = tempPRFMarks;
        DBMSMarks = tempDBMSMarks;
    }


    public static boolean checkBatchStatus(int batchNO) {
        for (int i = 0; i < batchNos.length; i++) {
            if (batchNO == batchNos[i]) {
                return batchStatus[i] == 1;
            }
        }
        return false;
    }

    public static boolean checkBatchExists(int batchNO) {
        for (int i = 0; i < batchNos.length; i++) {
            if (batchNO == batchNos[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkNICIsExists(String NIC) {
        for (int i = 0; i < NICs.length; i++) {
            if (NIC.equals(NICs[i])) {
                return true;
            }
        }
        return false;
    }

    public static String generateStudentId(int userInputBatchNo, int mode) {
        int studentCount = 0;
        for (int i = 0; i < studentIDs.length; i++) {
            String studentId = studentIDs[i];
            String batchNO = studentId.substring(4, 7);
            int batchNo = Integer.parseInt(batchNO);
            if (batchNo == userInputBatchNo) {
                studentCount++;
            }
        }

        String prefix = (mode == 1) ? "PR" : "OR";
        return prefix + "24" + userInputBatchNo + String.format("%03d", (studentCount + 2));
    }

    public static void addStudentDetailsToArrays(String studentId, String name, String NIC) {
        studentIDs[studentIDs.length - 1] = studentId;
        studentNames[studentNames.length - 1] = name;
        NICs[NICs.length - 1] = NIC;
        PRFMarks[PRFMarks.length - 1] = -2;
        DBMSMarks[DBMSMarks.length - 1] = -2;
    }


    public static void addStudent() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("|\t\t\t\tAdd Student\t\t\t|");
            System.out.println("-----------------------------------------------------------------\n");

            System.out.print("Enter batch Number(Student should be added): ");
            int batchNO = input.nextInt();
            System.out.println();

            if (!checkBatchExists(batchNO)) {
                System.out.println("\t This batch does not exist in the system...");
            } else if (checkBatchStatus(batchNO)) {
                System.out.print("Enter Student NIC : ");
                String NIC = input.next();
                System.out.println();

                if (checkNICIsExists(NIC)) {
                    System.out.println("\tThis student is already added to the system...");
                } else {
                    System.out.print("Enter Student name : ");
                    input.nextLine();
                    String studentName = input.nextLine();
                    System.out.println();

                    System.out.print("Enter Lecturer Mode(1 - PHYSICAL / 0 - ONLINE) : ");
                    int lecturerMode = input.nextInt();
                    System.out.println();

                    String studentId = generateStudentId(batchNO, lecturerMode);
                    System.out.println("\tStudent Registration No - " + studentId);

                    extendArrays();
                    addStudentDetailsToArrays(studentId, studentName, NIC);
                    System.out.println();
                }
            } else {
                System.out.println("\t Students cannot be added to this batch because enrollment is closed....");
            }

            System.out.print("\nDo you want to add another student (Y/N): ");
            char retryOption = input.next().charAt(0);
            clearConsole();
            if (retryOption != 'Y' && retryOption != 'y') {
                studentManagement();
                return;
            }
        } while (true);
    }


    public static int isRegistrationNoExists(String registrationNO) {
        for (int i = 0; i < studentIDs.length; i++) {
            if (registrationNO.equalsIgnoreCase(studentIDs[i])) {
                return i;
            }
        }
        return -1;
    }


    public static void UpdateStudent() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("|\t\t\t\tUpdate Student\t\t\t|");
            System.out.println("-------------------------------------------------------------------------\n");

            System.out.print("Enter Student Registration No : ");
            String regNo = input.next();
            int index = isRegistrationNoExists(regNo);

            if (index == -1) {
                System.out.println("\n\t This student does not exist in the system...");
            } else {
                System.out.println("\n\tStudent Name : " + studentNames[index]);
                System.out.println("\tStudent NIC  : " + NICs[index]);
                System.out.println("\nWhat do you want to update ?");
                System.out.println("(01) Student Name");
                System.out.println("(02) Student NIC");
                System.out.print("\nEnter your option - ");
                int opt = input.nextInt();

                if (opt == 1) {
                    clearConsole();
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("|\t\t\tStudent Name Update\t\t\t|");
                    System.out.println("-------------------------------------------------------------------------\n");
                    System.out.println("Registration No      : " + studentIDs[index]);
                    System.out.println("Student NIC          : " + NICs[index]);
                    System.out.println("Student Current Name : " + studentNames[index]);
                    System.out.print("\nEnter student name to update - ");
                    input.nextLine();
                    studentNames[index] = input.nextLine();
                    System.out.println("\nStudent name updated successfully...");
                } else if (opt == 2) {
                    clearConsole();
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("|\t\t\tStudent NIC Update\t\t\t|");
                    System.out.println("-------------------------------------------------------------------------\n");
                    System.out.println("Registration No     : " + studentIDs[index]);
                    System.out.println("Student Name        : " + studentNames[index]);
                    System.out.println("Student Current NIC : " + NICs[index]);
                    System.out.print("\nEnter student NIC to update - ");
                    String newNIC = input.next();

                    if (checkNICIsExists(newNIC)) {
                        System.out.println("\n\tThis student is already added to the system...");
                    } else {
                        NICs[index] = newNIC;
                        System.out.println("\nStudent NIC updated successfully...");
                    }
                }
            }

            System.out.print("\nDo you want to update another student details (Y/N): ");
            char retryOption = input.next().charAt(0);
            clearConsole();
            if (retryOption != 'Y' && retryOption != 'y') {
                studentManagement();
                return;
            }
        } while (true);
    }


    public static void deleteStudentProfile() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("------------------------------------------------");
            System.out.println("|\t\tDelete Student Profile \t\t|");
            System.out.println("------------------------------------------------\n");

            System.out.print("Enter Student Registration No : ");
            String regNo = input.next();
            int index = isRegistrationNoExists(regNo);

            if (index == -1) {
                System.out.println("\n\t This student does not exist in the system...");
            } else {
                System.out.println();
                printStudentFullDeatils(index);
                System.out.print("\nDo you want to delete this student profile (Y/N): ");
                char confirm = input.next().charAt(0);

                if (confirm == 'Y' || confirm == 'y') {
                    // Array shrink implementation
                    String[] tempStudentIDs = new String[studentIDs.length - 1];
                    String[] tempStudentNames = new String[studentNames.length - 1];
                    String[] tempNICs = new String[NICs.length - 1];
                    int[] tempPRFMarks = new int[PRFMarks.length - 1];
                    int[] tempDBMSMarks = new int[DBMSMarks.length - 1];

                    for (int i = 0, k = 0; i < studentIDs.length; i++) {
                        if (i == index) continue;
                        tempStudentIDs[k] = studentIDs[i];
                        tempStudentNames[k] = studentNames[i];
                        tempNICs[k] = NICs[i];
                        tempPRFMarks[k] = PRFMarks[i];
                        tempDBMSMarks[k] = DBMSMarks[i];
                        k++;
                    }

                    studentIDs = tempStudentIDs;
                    studentNames = tempStudentNames;
                    NICs = tempNICs;
                    PRFMarks = tempPRFMarks;
                    DBMSMarks = tempDBMSMarks;

                    System.out.println("\nStudent was successfully deleted from the system.");
                }
            }

            System.out.print("\nDo you want to delete another student profile (Y/N): ");
            char retryOption = input.next().charAt(0);
            clearConsole();
            if (retryOption != 'Y' && retryOption != 'y') {
                studentManagement();
                return;
            }
        } while (true);
    }


    public static void printStudentFullDeatils(int index) {
        System.out.println("\tRegistration No     : " + studentIDs[index]);
        System.out.println("\tStudent Name        : " + studentNames[index]);
        System.out.println("\tStudent NIC         : " + NICs[index]);

        if (PRFMarks[index] == -2) {
            System.out.println("\tStudent PRF Marks   : Not Conducted");
        } else if (PRFMarks[index] == -1) {
            System.out.println("\tStudent PRF Marks   : Absent");
        } else {
            System.out.println("\tStudent PRF Marks   : " + PRFMarks[index]);
        }

        if (DBMSMarks[index] == -2) {
            System.out.println("\tStudent DBMS Marks  : Not Conducted");
        } else if (DBMSMarks[index] == -1) {
            System.out.println("\tStudent DBMS Marks  : Absent");
        } else {
            System.out.println("\tStudent DBMS Marks  : " + DBMSMarks[index]);
        }

        System.out.println("\tStudent GPA         : " + calculateGPA(index));
    }


    public static double getGPA(int marks) {
        if (marks >= 90) return 4.25;
        if (marks >= 80) return 4.00;
        if (marks >= 75) return 3.70;
        if (marks >= 70) return 3.30;
        if (marks >= 65) return 3.00;
        if (marks >= 60) return 2.70;
        if (marks >= 55) return 2.30;
        if (marks >= 50) return 2.00;
        if (marks >= 45) return 1.70;
        if (marks >= 40) return 1.30;
        if (marks >= 30) return 1.00;
        return 0.70;
    }


    public static double calculateGPA(int index) {
        int prfMarks = PRFMarks[index];
        int dbmsMarks = DBMSMarks[index];

        double prfGPA = 0.0;
        double dbmsGPA = 0.0;

        if (prfMarks >= 0) prfGPA = getGPA(prfMarks);
        if (dbmsMarks >= 0) dbmsGPA = getGPA(dbmsMarks);

        return (prfGPA + dbmsGPA) / 2;
    }


    public static void viewStudentProfile() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("------------------------------------------------");
            System.out.println("|\t\tView Student's Profile \t\t|");
            System.out.println("------------------------------------------------\n");

            System.out.print("Enter Student Registration No : ");
            String registrationNo = input.next().toUpperCase();
            System.out.println();

            int index = isRegistrationNoExists(registrationNo);

            if (index >= 0) {
                printStudentFullDeatils(index);
            } else {
                System.out.println("\t This student does not exist in the system...");
            }

            System.out.print("\nDo you want to search another student details (Y/N): ");
            char retryOption = input.next().charAt(0);
            clearConsole();
            if (retryOption != 'Y' && retryOption != 'y') {
                studentManagement();
                return;
            }
        } while (true);
    }


    public static void studentManagement() {
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------");
        System.out.println("|\t\t\tStudent Management\t\t\t|");
        System.out.println("-----------------------------------------------------------------\n");

        System.out.println("[1] Add Student");
        System.out.println("\n[2] Update Student ");
        System.out.println("\n[3] View Student Profile");
        System.out.println("\n[4] Delete Student Profile");
        System.out.println("\n[5] Exit");
        System.out.println();

        System.out.print("Enter an option to continue : ");
        int studentOption = input.nextInt();

        switch (studentOption) {
            case 1:
                clearConsole();
                addStudent();
                break;
            case 2:
                clearConsole();
                UpdateStudent();
                break;
            case 3:
                clearConsole();
                viewStudentProfile();
                break;
            case 4:
                clearConsole();
                deleteStudentProfile();
                break;
            case 5:
                clearConsole();
                main(null);
                break;
            default:
                clearConsole();
                studentManagement();
                break;
        }
    }

    // Batch Management 
    public static void addBatch() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("------------------------------------------------");
            System.out.println("|\t\t\tAdd Batch\t\t|");
            System.out.println("------------------------------------------------\n");

            System.out.print("Enter Batch Number: ");
            int bNo = input.nextInt();

            if (checkBatchExists(bNo)) {
                System.out.println("\nBatch is already added to the system.");
            } else {
                extendBatchArrays();
                batchNos[batchNos.length - 1] = bNo;
                batchStatus[batchStatus.length - 1] = 1; // Default ENROLLMENT OPEN
                System.out.println("\nBatch was successfully added to the system.");
            }

            System.out.print("\nDo you want to add another batch to the system (Y/N): ");
            char ch = input.next().charAt(0);
            clearConsole();
            if (ch != 'Y' && ch != 'y') {
                batchManagement();
                return;
            }
        } while (true);
    }

    public static void updateBatch() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("------------------------------------------------");
            System.out.println("|\t\t\tUpdate Batch\t\t|");
            System.out.println("------------------------------------------------\n");

            System.out.print("Enter Batch Number: ");
            int bNo = input.nextInt();

            int index = -1;
            for (int i = 0; i < batchNos.length; i++) {
                if (batchNos[i] == bNo) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println("\nThis batch does not exist in the system.");
            } else {
                String curStatus = (batchStatus[index] == 1) ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
                String targetStatus = (batchStatus[index] == 1) ? "ENROLLMENT CLOSED" : "ENROLLMENT OPEN";
                System.out.println("Current Status: " + curStatus);
                System.out.print("Do you want to change the batch status to " + targetStatus + "(Y/N) ? ");
                char confirm = input.next().charAt(0);

                if (confirm == 'Y' || confirm == 'y') {
                    batchStatus[index] = (batchStatus[index] == 1) ? 0 : 1;
                    System.out.println("Batch Status updated successfully...");
                }
            }

            System.out.print("\nDo you want to update another batch details (Y/N): ");
            char ch = input.next().charAt(0);
            clearConsole();
            if (ch != 'Y' && ch != 'y') {
                batchManagement();
                return;
            }
        } while (true);
    }

    public static void viewBatches() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|\t\t\tView Batches\t\t\t|");
        System.out.println("-----------------------------------------------------------------\n");

        System.out.printf("%-5s %-10s %-15s %-20s\n", "No", "Batch No", "Student Count", "Status");

        for (int i = 0; i < batchNos.length; i++) {
            int count = 0;
            for (int j = 0; j < studentIDs.length; j++) {
                int bNo = Integer.parseInt(studentIDs[j].substring(4, 7));
                if (bNo == batchNos[i]) count++;
            }
            String statusStr = (batchStatus[i] == 1) ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
            System.out.printf("%-5d %-10d %-15d %-20s\n", (i + 1), batchNos[i], count, statusStr);
        }

        System.out.print("\nDo you want to go to the home page (Y/N): ");
        char ch = input.next().charAt(0);
        clearConsole();
        if (ch == 'Y' || ch == 'y') {
            main(null);
        } else {
            batchManagement();
        }
    }

    public static void batchManagement() {
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------");
        System.out.println("|\t\t\tBatch Management\t\t\t|");
        System.out.println("-----------------------------------------------------------------\n");

        System.out.println("[1] Add Batch");
        System.out.println("\n[2] Update Batch ");
        System.out.println("\n[3] View Batches");
        System.out.println("\n[4] Exit");
        System.out.println();

        System.out.print("Enter an option to continue : ");
        int opt = input.nextInt();

        switch (opt) {
            case 1:
                clearConsole();
                addBatch();
                break;
            case 2:
                clearConsole();
                updateBatch();
                break;
            case 3:
                clearConsole();
                viewBatches();
                break;
            case 4:
                clearConsole();
                main(null);
                break;
            default:
                clearConsole();
                batchManagement();
                break;
        }
    }

    //  Grade Management 
    public static void updatePRFMarks() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|\t\t\tPRF Marks Update\t\t\t|");
            System.out.println("-----------------------------------------------------------------\n");

            System.out.print("Enter Student Registration No : ");
            String regNo = input.next();
            int index = isRegistrationNoExists(regNo);

            if (index == -1) {
                System.out.println("\n\t This student does not exist in the system...");
            } else {
                System.out.println("Registration no : " + studentIDs[index]);
                System.out.println("Student Name    : " + studentNames[index]);
                System.out.println("Student NIC     : " + NICs[index]);

                boolean update = true;
                if (PRFMarks[index] >= 0) {
                    System.out.println("\nThis student has already completed the PRF module.");
                    System.out.println("PRF Marks: " + PRFMarks[index]);
                    System.out.print("Do you want to update this student's PRF marks? (Y/N): ");
                    char ch = input.next().charAt(0);
                    if (ch != 'Y' && ch != 'y') update = false;
                } else if (PRFMarks[index] == -1) {
                    System.out.println("\nThis student was absent from the exam. You can update the marks if they participate in it.");
                }

                if (update) {
                    int marks;
                    while (true) {
                        System.out.print("Enter PRF Marks: ");
                        marks = input.nextInt();
                        if ((marks >= 0 && marks <= 100) || marks == -1) break;
                        System.out.println("Invalid Marks! Please enter between 0-100 or -1 for Absent.");
                    }
                    PRFMarks[index] = marks;
                    System.out.println("This student PRF Marks updated successfully...");
                }
            }

            System.out.print("\nDo you want to update another student PRF marks (Y/N): ");
            char ch = input.next().charAt(0);
            clearConsole();
            if (ch != 'Y' && ch != 'y') {
                gradeManagement();
                return;
            }
        } while (true);
    }


    public static void updateDBMSMarks() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|\t\t\tDBMS Marks Update\t\t\t|");
            System.out.println("-----------------------------------------------------------------\n");

            System.out.print("Enter Student Registration No : ");
            String regNo = input.next();
            int index = isRegistrationNoExists(regNo);

            if (index == -1) {
                System.out.println("\n\t This student does not exist in the system...");
            } else {
                System.out.println("Registration no : " + studentIDs[index]);
                System.out.println("Student Name    : " + studentNames[index]);
                System.out.println("Student NIC     : " + NICs[index]);

                boolean update = true;
                if (DBMSMarks[index] >= 0) {
                    System.out.println("\nThis student has already completed the DBMS module.");
                    System.out.println("DBMS Marks: " + DBMSMarks[index]);
                    System.out.print("Do you want to update this student's DBMS marks? (Y/N): ");
                    char ch = input.next().charAt(0);
                    if (ch != 'Y' && ch != 'y') update = false;
                } else if (DBMSMarks[index] == -1) {
                    System.out.println("\nThis student was absent from the exam. You can update the marks if they participate in it.");
                }

                if (update) {
                    int marks;
                    while (true) {
                        System.out.print("Enter DBMS Marks: ");
                        marks = input.nextInt();
                        if ((marks >= 0 && marks <= 100) || marks == -1) break;
                        System.out.println("Invalid Marks! Please enter between 0-100 or -1 for Absent.");
                    }
                    DBMSMarks[index] = marks;
                    System.out.println("This student DBMS Marks updated successfully...");
                }
            }

            System.out.print("\nDo you want to update another student DBMS marks (Y/N): ");
            char ch = input.next().charAt(0);
            clearConsole();
            if (ch != 'Y' && ch != 'y') {
                gradeManagement();
                return;
            }
        } while (true);
    }


    public static void gradeManagement() {
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------");
        System.out.println("|\t\t\tGrade Management\t\t\t|");
        System.out.println("-----------------------------------------------------------------\n");

        System.out.println("[1] PRF Marks Update");
        System.out.println("\n[2] DBMS Marks Update");
        System.out.println("\n[3] Exit");
        System.out.println();

        System.out.print("Enter an option to continue : ");
        int opt = input.nextInt();

        switch (opt) {
            case 1:
                clearConsole();
                updatePRFMarks();
                break;
            case 2:
                clearConsole();
                updateDBMSMarks();
                break;
            case 3:
                clearConsole();
                main(null);
                break;
            default:
                clearConsole();
                gradeManagement();
                break;
        }
    }

    //  Report Generator 
    public static void studentRegistrationReport() {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tStudent Registration Report\t\t\t\t\t|");
        System.out.println("-------------------------------------------------------------------------------------------------\n");

        //  sorted indices
        int[] indices = new int[studentIDs.length];
        for (int i = 0; i < indices.length; i++) indices[i] = i;

        // Bubble sort student name
        for (int i = 0; i < indices.length - 1; i++) {
            for (int j = 0; j < indices.length - 1 - i; j++) {
                if (studentNames[indices[j]].compareToIgnoreCase(studentNames[indices[j + 1]]) > 0) {
                    int temp = indices[j];
                    indices[j] = indices[j + 1];
                    indices[j + 1] = temp;
                }
            }
        }

        System.out.printf("%-5s %-15s %-25s %-15s %-10s %-10s %-5s\n", "No", "Registration No", "Student Name", "NIC", "PRF Marks", "DBMS Marks", "GPA");

        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            String prfStr = (PRFMarks[idx] == -2) ? "N/C" : (PRFMarks[idx] == -1) ? "Absent" : String.valueOf(PRFMarks[idx]);
            String dbmsStr = (DBMSMarks[idx] == -2) ? "N/C" : (DBMSMarks[idx] == -1) ? "Absent" : String.valueOf(DBMSMarks[idx]);
            double gpa = calculateGPA(idx);

            System.out.printf("%-5d %-15s %-25s %-15s %-10s %-10s %-5.2f\n", (i + 1), studentIDs[idx], studentNames[idx], NICs[idx], prfStr, dbmsStr, gpa);
        }

        System.out.print("\nDo you want to go to the home page (Y/N): ");
        char ch = input.next().charAt(0);
        clearConsole();
        if (ch == 'Y' || ch == 'y') {
            main(null);
        } else {
            reportGenerator();
        }
    }


    public static void batchWiseStudentReport() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|\t\t\tBatch-wise Student Report\t\t|");
        System.out.println("-----------------------------------------------------------------\n");

        for (int i = 0; i < batchNos.length; i++) {
            System.out.println("[" + (i + 1) + "] " + batchNos[i] + " Batch");
        }
        System.out.println("[" + (batchNos.length + 1) + "] Exit");

        System.out.print("\nEnter an option to continue > ");
        int opt = input.nextInt();

        if (opt >= 1 && opt <= batchNos.length) {
            clearConsole();
            int selectedBatch = batchNos[opt - 1];

            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("|\t\t\t\t" + selectedBatch + " Batch Student Report\t\t\t\t\t|");
            System.out.println("-------------------------------------------------------------------------------------------------\n");

            System.out.printf("%-5s %-15s %-25s %-15s %-10s %-10s %-5s\n", "No", "Registration No", "Student Name", "NIC", "PRF Marks", "DBMS Marks", "GPA");

            int count = 1;
            for (int i = 0; i < studentIDs.length; i++) {
                int bNo = Integer.parseInt(studentIDs[i].substring(4, 7));
                if (bNo == selectedBatch) {
                    String prfStr = (PRFMarks[i] == -2) ? "N/C" : (PRFMarks[i] == -1) ? "Absent" : String.valueOf(PRFMarks[i]);
                    String dbmsStr = (DBMSMarks[i] == -2) ? "N/C" : (DBMSMarks[i] == -1) ? "Absent" : String.valueOf(DBMSMarks[i]);
                    double gpa = calculateGPA(i);

                    System.out.printf("%-5d %-15s %-25s %-15s %-10s %-10s %-5.2f\n", count++, studentIDs[i], studentNames[i], NICs[i], prfStr, dbmsStr, gpa);
                }
            }

            System.out.print("\nDo you want to view another batch report (Y/N): ");
            char ch = input.next().charAt(0);
            clearConsole();
            if (ch == 'Y' || ch == 'y') {
                batchWiseStudentReport();
            } else {
                reportGenerator();
            }
        } else {
            clearConsole();
            reportGenerator();
        }
    }

    public static void industryTrainingEligibilityReport() {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tIndustry Training Eligibility Student Report\t\t\t|");
        System.out.println("-------------------------------------------------------------------------------------------------\n");

        System.out.printf("%-5s %-15s %-25s %-15s %-10s %-10s %-5s\n", "No", "Registration No", "Student Name", "NIC", "PRF Marks", "DBMS Marks", "GPA");

        int count = 1;
        for (int i = 0; i < studentIDs.length; i++) {
            double gpa = calculateGPA(i);
            if (gpa > 3.25 && PRFMarks[i] > 50 && DBMSMarks[i] > 50) {
                System.out.printf("%-5d %-15s %-25s %-15s %-10d %-10d %-5.2f\n", count++, studentIDs[i], studentNames[i], NICs[i], PRFMarks[i], DBMSMarks[i], gpa);
            }
        }

        System.out.print("\nDo you want to go to homepage (Y/N): ");
        char ch = input.next().charAt(0);
        clearConsole();
        if (ch == 'Y' || ch == 'y') {
            main(null);
        } else {
            reportGenerator();
        }
    }

    public static void reportGenerator() {
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------");
        System.out.println("|\t\t\tReport Generator\t\t\t|");
        System.out.println("-----------------------------------------------------------------\n");

        System.out.println("[1] Student Registration Report");
        System.out.println("\n[2] Batch-wise Student Report");
        System.out.println("\n[3] Industry Training Eligibility Report");
        System.out.println("\n[4] Exit");
        System.out.println();

        System.out.print("Enter an option to continue > ");
        int opt = input.nextInt();

        switch (opt) {
            case 1:
                clearConsole();
                studentRegistrationReport();
                break;
            case 2:
                clearConsole();
                batchWiseStudentReport();
                break;
            case 3:
                clearConsole();
                industryTrainingEligibilityReport();
                break;
            case 4:
                clearConsole();
                main(null);
                break;
            default:
                clearConsole();
                reportGenerator();
                break;
        }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------");
        System.out.println("|\t\t\tiCET Student Management System\t\t|");
        System.out.println("-----------------------------------------------------------------\n");

        System.out.println("[1] Student Management");
        System.out.println("\n[2] Batch Management ");
        System.out.println("\n[3] Grade Management");
        System.out.println("\n[4] Report Generator");
        System.out.println("\n[5] Exit");

        System.out.println();

        System.out.print("Enter an option to continue : ");
        int mainOption = input.nextInt();

        switch (mainOption) {
            case 1:
                clearConsole();
                studentManagement();
                break;
            case 2:
                clearConsole();
                batchManagement();
                break;
            case 3:
                clearConsole();
                gradeManagement();
                break;
            case 4:
                clearConsole();
                reportGenerator();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Option.....");
                System.exit(0);
        }
    }
}
