package com.example.hrmanagementmilan;



    public class login {

        private int loginid;


        private String Email;

        private String Password;

        public int getloginid() {
            return loginid;
        }

        public void setloginid(int loginid) {
            this.loginid = loginid;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
        }

        public login(int loginid, String Email, String Password) {
            this.loginid = loginid;

            this.Email = Email;
            this.Password = Password;
        }

    }