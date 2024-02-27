package org.example.password;

public class User {
    public String getPassword() {
        return password;
    }

    private String password;

    //TO-BE
    public void initPassword(PasswordGenerator passwordGenerator){
        //AS-IS
        //내부에서 생성되는 객체는 강한 의존성을 가짐.
        //해당 객체에 인터페이스를 제공함으로써 결합도를 낮출 수 있으며 올바른 테스트가 가능해진다.

        //RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        //String randomPassword = randomPasswordGenerator.generatePassword();


        String randomPassword = passwordGenerator.generatePassword();

        /**
         * 비밀번호가 최소 8자 이상 12자 이하가 아니라면 초기화 시키지 않는다.
         */
        if(randomPassword.length() >= 8 && randomPassword.length() <= 12){
            this.password = randomPassword;
        }
    }
}
