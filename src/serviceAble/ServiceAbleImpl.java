package serviceAble;

import model.Gender;
import model.Group;
import model.Lesson;
import model.Student;

import java.util.*;


    public class ServiceAbleImpl implements ServiceAble {
        private static long count;
//    private List<Group> groups = new ArrayList<>();


        @Override
        public Group getNewGroup(List<Group> groups, String nameOfGroup, String deskription) {
            Group group = new Group();
            boolean isTrue = true;
            while (isTrue) {
                try {
                    boolean foundGroup = true;
                    group.setName(nameOfGroup);
                    group.setDescriptions(deskription);
                    for (Group g : groups) {
                        if (g.getName().equalsIgnoreCase(nameOfGroup)) {
                            isTrue = false;
                            throw new CheckInfo("\nA group with the same name already exists !!!\n");
                        } else {
                            isTrue = false;
                        }
                    }
                    if (foundGroup) {
                        count++;
                        group.setId(count);
                        groups.add(group);
                        isTrue = false;
                        System.out.println(group.toString());
                        System.out.println("\n * Group saved successfully * \n");
                    }
                } catch (CheckInfo e) {
                    System.out.println(e.getMessage());
                }
            }
            return group;
        }

        @Override
        public void getGroupByName(List<Group> groups, String nameOfGroup) {
            try {
                boolean foundGroup = false;
                for (Group group : groups) {
                    if (group.getName().equalsIgnoreCase(nameOfGroup)) {
                        System.out.println(group.toString());
                        foundGroup = true;
                        break;
                    }
                }
                if (!foundGroup) {
                    throw new CheckInfo("\n - Group not found. - \n");
                }
            } catch (CheckInfo e) {
                System.out.println(e.getMessage());
            }
        }

        @Override
        public void updateGroupName(List<Group> groups, String oldNameOfGroup, String newNameOfGroup) {
            try {
                boolean foundGroup = false;
                for (Group g : groups) {
                    if (g.getName().equalsIgnoreCase(oldNameOfGroup)) {
                        g.setName(newNameOfGroup);
                        System.out.println(g.toString());
                        foundGroup = true;
                        break;
                    }
                }
                if (!foundGroup) {
                    throw new CheckInfo("\nGroup have not found \n");
                }
            } catch (CheckInfo e) {
                System.out.println(e.getMessage());
            }
        }
        @Override
        public void addNewStudentByGroup(List<Group> groups,String studetnFirstName,String studentsLastName,String groupName,String emailStu,int gender ,String password) {
            Group group = new Group();
            Student student = new Student();
            List<Student> students = new ArrayList<>();
            boolean isTrue = true;
            boolean isTrueNameAndLastName = true;
            boolean isTrueEmail = true;
            boolean isTrueAge = true;
            boolean isTrueGender = true;
            boolean isTruePassword = true;
            while (isTrue) {
                while (isTrueNameAndLastName) {
                    try {
                        if (!studetnFirstName.matches("-?\\d+") && !studentsLastName.matches("-?\\d+")) {
                            boolean isFalse = false;
                            if (!groups.isEmpty()) {
                                for (Group g : groups) {
                                    if (!g.getStudents().isEmpty()) {
                                        for (Student s : g.getStudents()) {
                                            if (!s.getFirstName().contains(studetnFirstName) && !s.getLastName().contains(studentsLastName)) {
                                                student.setFirstName(studetnFirstName);
                                                student.setLastName(studentsLastName);
                                                isTrueNameAndLastName = false;
                                            } else {
                                                isFalse = true;
                                            }
                                        }
                                    } else {
                                        student.setFirstName(studetnFirstName);
                                        student.setLastName(studentsLastName);
                                        isTrueNameAndLastName = false;
                                    }
                                }
                            } else {
                                student.setFirstName(studetnFirstName);
                                student.setLastName(studentsLastName);
                                isTrueNameAndLastName = false;
                            }
                            if (isFalse) {
                                throw new CheckInfo("Такое имя и фамилия уже сущевствует");
                            }
                        } else {
                            throw new CheckInfo("Имя и фамилия не могут быть цифрой");
                        }
                    } catch (CheckInfo e) {
                        System.out.println(e.getMessage());
                    }
                }

                while (isTrueEmail) {
                    try {
                        boolean checkEmail = false;
                        if (emailStu.contains("@")) {
                            for (Group g : groups) {
                                if (!g.getStudents().isEmpty()) {
                                    for (Student s : g.getStudents()) {
                                        if (!s.getEmail().contains(emailStu)) {
                                            student.setEmail(emailStu);
                                            isTrueEmail = false;
                                            break;
                                        } else {
                                            checkEmail = true;
                                        }
                                    }
                                } else {
                                    student.setEmail(emailStu);
                                    isTrueEmail = false;
                                }
                            }
                        } else {
                            throw new CheckInfo("Not correct email");
                        }
                        if (checkEmail) {
                            throw new CheckInfo("email is already exist");
                        }
                    } catch (CheckInfo e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (isTrueGender) {
                    try {
                        switch (gender) {
                            case 1 -> {
                                student.setGender(Gender.MALE);
                                isTrueGender = false;
                            }
                            case 2 -> {
                                student.setGender(Gender.FEMALE);
                                isTrueGender = false;
                            }
                            default -> throw new CheckInfo("Choose your gender ");
                        }
                    } catch (CheckInfo e) {
                        isTrueGender = true;
                        System.out.println(e.getMessage());
                    }
                }
                while (isTruePassword) {
                    try {
                        boolean isFalseLength = false;
                        if (password.length() >= 8) {
                            student.setPassword(password);
                            isTruePassword = false;
                            break;
                        } else {
                            isFalseLength = true;
                        }
                        if (isFalseLength) {
                            throw new CheckInfo("Password must contain 8 symvole");
                        }
                    } catch (CheckInfo e) {
                        isTruePassword = true;
                        System.out.println(e.getMessage());
                    }
                }
                for (Group g : groups) {
                    if (g.getName().equalsIgnoreCase(groupName)) {
                        student.setId(g.getStudents().size());
                        g.getStudents().add(student);
                        isTrue = false;
                        break;
                    }
                }
            }
        }
        @Override
        public void getAllGroup(List<Group> groups) {
            for (Group g : groups) {
                System.out.println(g.toString());
            }
        }


        @Override
        public void updateNameAndLastNameStudent(List<Group> groups) {
            boolean isTrue = true;
            while (isTrue) {
                try {
                    System.out.println("Enter student's first name:");
                    String firstName = new Scanner(System.in).nextLine();
                    System.out.println("Enter student's last name:");
                    String lastName = new Scanner(System.in).nextLine();
                    for (Group group : groups) {
                        for (Student student : group.getStudents()) {
                            if (student.getFirstName().equalsIgnoreCase(firstName) && student.getLastName().equalsIgnoreCase(lastName)) {
                                System.out.println("Enter new first name:");
                                String newFirstName = new Scanner(System.in).nextLine();
                                System.out.println("Enter new last name:");
                                String newLastName = new Scanner(System.in).nextLine();
                                boolean isDuplicate = false;
                                for (Student stud : group.getStudents()) {
                                    if (stud.getLastName().equalsIgnoreCase(newLastName) &&
                                            stud.getFirstName().equalsIgnoreCase(newFirstName)) {
                                        isDuplicate = true;
                                        break;
                                    }
                                }
                                if (isDuplicate) {
                                    throw new CheckInfo("A student with this name already exists");
                                }
                                student.setFirstName(newFirstName);
                                student.setLastName(newLastName);
                                isTrue = false;
                                break;
                            }
                        }
                        if (!isTrue) {
                            break;
                        }
                    }
                    if (isTrue) {
                        throw new CheckInfo("No student with this name found");
                    }
                } catch (CheckInfo e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        public void findStudentByFirstName(List<Group> groups) {
            boolean isTrue = true;
            while (isTrue) {
                try {
                    System.out.println("Enter first name student");
                    String name = new Scanner(System.in).nextLine();
                    boolean isFalse = false;
                    for (Group g : groups) {
                        for (Student s : g.getStudents()) {
                            if (s.getFirstName().contains(name)) {
                                System.out.println(s.toString());
                                isTrue = false;
                                break;
                            } else {
                                isFalse = true;
                            }
                        }
                    }
                    if (isFalse) {
                        throw new CheckInfo("Not found");
                    }
                } catch (CheckInfo e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        @Override
        public void getAllStudentsByGroupName(List<Group> groups) {
            boolean isTure = true;
            while (isTure) {
                try {
                    System.out.println("Enter name group");
                    String name = new Scanner(System.in).nextLine();
                    boolean isFalse = false;
                    for (Group g : groups) {
                        if (g.getName().contains(name)) {
                            System.out.println(g.getStudents());
                            isTure = false;
                            break;
                        } else {
                            isFalse = true;
                        }
                    }
                    if (isFalse) {
                        throw new CheckInfo("Not found group");
                    }
                } catch (CheckInfo e) {
                    System.err.println(e.getMessage());
                }
            }

        }

        @Override
        public void getAllLessonStudents(List<Group> groups) {
            boolean isTrue = true;
            boolean isFalse = false;
            while (isTrue) {
                try {
                    System.out.println("Enter email students");
                    String email = new Scanner(System.in).nextLine().toLowerCase();
                    for (Group g : groups) {
                        for (Student s : g.getStudents()) {
                            if (s.getEmail().contains(email)) {
                                System.out.println(g.getLessons());
                                isFalse = false;
                                isTrue = false;

                            } else {
                                isFalse = true;
                            }
                        }

                    }
                    if (isFalse) {
                        throw new CheckInfo("Not found student email");
                    }
                } catch (CheckInfo e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        @Override
        public void deleteStudentFromGroup(List<Group> groups) {
            boolean isTrue = true;
            while (isTrue) {
                try {
                    System.out.println("Enter email student");
                    String email = new Scanner(System.in).nextLine().toLowerCase();
                    boolean isFalse = false;
                    for (Group g : groups) {
                        for (Student s : g.getStudents()) {
                            if (s.getEmail().contains(email)) {
                                g.getStudents().remove(s);
                                System.out.println("Delete");
                                isTrue = false;
                                break;
                            } else {
                                isFalse = true;
                            }
                        }
                    }
                    if (isFalse) {
                        throw new CheckInfo("Not found");
                    }
                } catch (CheckInfo e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        @Override
        public void newLesson(List<Group> groups) {
            List<Lesson> lessons = new ArrayList<>();
            Lesson lesson = new Lesson();
            boolean isTrue = true;
            while (isTrue) {
                try {
                    System.out.println("Enter name group");
                    String nameGroup = new Scanner(System.in).nextLine();
                    boolean isFalse1 = false;
                    for (Group g : groups) {
                        if (!g.getName().equalsIgnoreCase(nameGroup)) {
                            isFalse1 = true;
                        } else {
                            isFalse1 = false;
                            break;
                        }
                    }
                    if (isFalse1){
                        throw new CheckInfo("Group not found ");
                    }
                    System.out.println("Enter name lesson");
                    String nameLesson = new Scanner(System.in).nextLine();
                    System.out.println("Enter description lesson");
                    String description = new Scanner(System.in).nextLine();
                    boolean isFalse = false;
                    for (Group g : groups) {
                        if (g.getName().equalsIgnoreCase(nameGroup)) {
                            if (!g.getLessons().isEmpty()) {
                                for (Lesson l : g.getLessons()) {
                                    if (l.getName().equalsIgnoreCase(nameLesson)) {
                                        throw new CheckInfo("There is already such a lesson");
                                    } else {
                                        isFalse = true;
                                        break;
                                    }
                                }
                            } else {
                                lesson.setId(g.getLessons().size());
                                lesson.setName(nameLesson);
                                lesson.setDescription(description);
                                g.getLessons().add(lesson);
                            }
                        }
                        if (isFalse) {
                            lesson.setId(g.getLessons().size() + 1);
                            lesson.setName(nameLesson);
                            lesson.setDescription(description);
                            g.getLessons().add(lesson);
                            isTrue = false;
                            break;
                        }
                    }
                    isTrue = false;
                } catch (CheckInfo e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        @Override
        public void getByLessonName(List<Group> groups) {
            boolean isTure = true;
            boolean isFalse = false;
            while (isTure) {
                try {
                    System.out.println("Enter name lesson");
                    String name = new Scanner(System.in).nextLine();

                    for (Group g : groups) {
                        for (Lesson l : g.getLessons()) {
                            if (l.getName().equalsIgnoreCase(name)) {
                                System.out.println(l.toString());
                                isTure = false;
                                isFalse = false;
                                break;
                            } else {
                                isFalse = true;
                            }
                        }
                    }
                    if (isFalse) {
                        throw new CheckInfo("lesson not found");
                    }
                } catch (CheckInfo e) {
                    System.err.println(e.getMessage());
                }

            }
        }

        @Override
        public void getLessonByGroup(List<Group> groups) {
            boolean isTrue = true;
            while (isTrue) {
                try {
                    System.out.println("Enter name group");
                    String name = new Scanner(System.in).nextLine();
                    boolean isFalse = false;
                    for (Group g : groups) {
                        if (g.getName().equalsIgnoreCase(name)) {
                            System.out.println(g.getLessons());
                            isTrue = false;
                            break;
                        } else {
                            isFalse = true;
                        }
                    }
                    if (isFalse) {
                        throw new CheckInfo("Group not found");
                    }
                } catch (CheckInfo e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        @Override
        public void deleteLessonByGroup(List<Group> groups) {
            boolean isTrue = true;
            while (isTrue) {
                try {
                    System.out.println("Enter name lesson");
                    String name = new Scanner(System.in).nextLine();
                    boolean isFalse = false;
                    for (Group g : groups) {
                        for (Lesson l : g.getLessons()) {
                            if (l.getName().equalsIgnoreCase(name)) {
                                g.getLessons().remove(l);
                                System.out.println("Delete");
                                isTrue = false;
                                isFalse = false;
                                break;
                            } else {
                                isTrue = false;
                                isFalse = true;
                            }
                        }
                    }
                    if (!isFalse){
                        isTrue = false;
                        isFalse = true;
                    }
                    if (isFalse) {
                        throw new CheckInfo("Lesson not found");
                    }
                } catch (CheckInfo e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        @Override
        public void deleteGroup(List<Group> groups) {
            try {
                System.out.println("Enter name group");
                String name = new Scanner(System.in).nextLine();
                boolean isFalse = false;
                for (Group g : groups) {
                    if (g.getName().equalsIgnoreCase(name)) {
                        groups.remove(g);
                        System.out.println("Delete");
                        break;
                    } else {
                        isFalse = true;
                    }
                }
                if (isFalse) {
                    throw new CheckInfo("Group not found");
                }
            } catch (CheckInfo e) {
                System.err.println(e.getMessage());
            }
        }
    }

