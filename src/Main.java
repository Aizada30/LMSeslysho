
      import model.Group;
import serviceAble.ServiceAbleImpl;

      import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {
                List<Group> groups = new ArrayList<>();
                ServiceAbleImpl serviceAble = new ServiceAbleImpl();
                LocalTime localTime = LocalTime.now();
                System.out.println("      Welcome\n" + localTime.getHour() + ":" + localTime.getMinute());
                System.out.println("Enter login and password");
                String login = "ai";
                String password = "12";
                System.out.println("Enter login");
                String loginScan = new Scanner(System.in).nextLine();
                System.out.println("Enter password");
                String passwordScan = new Scanner(System.in).nextLine();
                if (loginScan.equalsIgnoreCase(login) && passwordScan.equals(password) ) {
                    Scanner scanner = new Scanner (System.in);
                    while (true) {
                        try {
                            System.out.println("""
                            1  -> Add new group       
                            2  -> Get group by name
                            3  -> Update group name
                            4  -> Get all groups
                            5  -> Add new student to group
                            6  -> Update student
                            7  -> Find student by first name
                            8  -> Get all students by group name
                            9  -> Get all student's lesson
                            10 -> Delete student from group
                            11 -> Add new lesson to group
                            12 -> Get lesson by name
                            13 -> Get all lesson by group name
                            14 -> Delete lesson from group
                            15 -> Delete group
                            """);
                            switch (new Scanner(System.in).nextInt()) {
                                case 1 -> {
                                    System.out.println("Enter a group name : ");
                                    String nameOfGroup = scanner.nextLine();
                                    System.out.println("Enter a diskription : ");
                                    String diskription = scanner.nextLine();
                                    serviceAble.getNewGroup(groups,nameOfGroup,diskription);
                                }
                                case 2 -> {
                                    System.out.println("Enter group name:");
                                    String nameOfGroup = scanner.nextLine().toLowerCase();
                                    serviceAble.getGroupByName(groups,nameOfGroup);
                                }
                                case 3 -> {
                                    System.out.println("Enter a old name of Group : ");
                                    String oldName = new Scanner(System.in).nextLine();
                                    System.out.println("Enter a new name of Group : ");
                                    String newName= new Scanner(System.in).nextLine();
                                    serviceAble.updateGroupName(groups,oldName,newName);
                                }
                                case 4 -> {
                                    serviceAble.getAllGroup(groups);
                                }
                                case 5 -> {
                                    System.out.println("Enter a group name");
                                    String groupName= scanner.nextLine();
                                    System.out.println("Enter first name");
                                    String firstName = new Scanner(System.in).nextLine();
                                    System.out.println("Enter last name");
                                    String lastName = new Scanner(System.in).nextLine();
                                    System.out.println("Enter email");
                                    String email = new Scanner(System.in).nextLine().toLowerCase();
                                    System.out.println("    Enter gender\n1. Male\n2. Female");
                                    int gender = new Scanner(System.in).nextInt();
                                    System.out.println("Enter password 8 symbols");
                                    String passwordStu = new Scanner(System.in).nextLine();
                                    serviceAble.addNewStudentByGroup(groups,firstName,lastName,groupName,email,gender,passwordStu );
                                }
                                case 6 -> {
                                    serviceAble.updateNameAndLastNameStudent(groups);
                                }
                                case 7 -> {
                                    serviceAble.findStudentByFirstName(groups);
                                }
                                case 8 -> {
                                    serviceAble.getAllStudentsByGroupName(groups);
                                }
                                case 9 -> {
                                    serviceAble.getAllLessonStudents(groups);
                                }
                                case 10 -> {
                                    serviceAble.deleteStudentFromGroup(groups);
                                }
                                case 11 -> {
                                    serviceAble.newLesson(groups);
                                }
                                case 12 -> {
                                    serviceAble.getByLessonName(groups);
                                }
                                case 13 -> {
                                    serviceAble.getLessonByGroup(groups);
                                }
                                case 14 -> {
                                    serviceAble.deleteLessonByGroup(groups);
                                }
                                case 15 -> {
                                    serviceAble.deleteGroup(groups);
                                }
                            }


                        }catch (InputMismatchException e){
                            System.out.println("Enter only numbers" );
                        }
                    }
                }else {
                    System.out.println("Not found");
                }

            }
        }
