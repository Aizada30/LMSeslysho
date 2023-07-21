package model;

    public class Student {
        private long id;
        private String firstName;
        private String lastName;
        private String email;
        private Gender gender;
        private String password;

        public Student(){

        }

        public Student(long id, String firstName, String lastName, String email, Gender gender, String password) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.gender = gender;
            this.password = password;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "\n          ID: " + id +
                    "\nFirst name: " + firstName +
                    "\nLast name: " + lastName +
                    "\nEmail: " + email +
                    "\nGender: " + gender +
                    "\nPassword: " + password;
        }
    }

