package serviceAble;




import model.Group;

import java.util.List;


    public interface ServiceAble {
        Group getNewGroup(List<Group> groups,String nameOfGroup,String deskription);
        void getGroupByName(List<Group> groups,String nameOfGroup);

        void updateGroupName(List<Group> groups,String oldNameOfGroup ,String newNameOfGroup);

        void getAllGroup(List<Group> groups);

        void addNewStudentByGroup(List<Group> groups,String studetnFirstName,String studentsLastName,String groupName,String emailStu,int gender ,String password);

        void updateNameAndLastNameStudent(List<Group> groups);

        void findStudentByFirstName(List<Group> groups);

        void getAllStudentsByGroupName(List<Group> groups);

        void getAllLessonStudents(List<Group> groups);

        void deleteStudentFromGroup(List<Group> groups);

        void newLesson(List<Group> groups);

        void getByLessonName(List<Group> groups);

        void getLessonByGroup(List<Group> groups);

        void deleteLessonByGroup(List<Group> groups);

        void deleteGroup(List<Group> groups);
    }

