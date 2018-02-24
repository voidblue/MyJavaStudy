package BuliderAndFinal;

public class TestClass {
    //불변 클래스로 만드는게 좋다!
    final private int age, length, weight, IQ;
    final private String name, IDCode, nickname;

    public static class Builder{
        private int age, length, weight, IQ;
        private String name, IDCode, nickname;

        public Builder(String IDCode, String name) {
            this.IDCode = IDCode; //필수인자
            this.name = name;

            age = 0;
            weight = 0;
            IQ = 0;
            nickname = "None";
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }
        public Builder length(int length){
            this.length = length;
            return this;
        }
        public Builder weight(int weight){
            this.weight = weight;
            return this;
        }
        public Builder IQ(int IQ){
            this.IQ = IQ;
            return this;
        }
        public Builder nickname(String nickname){
            this.nickname = nickname;
            return this;
        }

        public TestClass build(){
            return new TestClass(this);
        }

    }


    private TestClass(Builder builder) {
        //TODO 프라이빗 변수인데 왜 되지??
        this.age = builder.age;
        this.length = builder.length;
        this.weight = builder.weight;
        this.IQ = builder.IQ;
        this.name = builder.name;
        this.IDCode = builder.IDCode;
        this.nickname = builder.nickname;
    }

    public void printAll(){
        System.out.println("이름 : " + name + "\n나이 : " + age + "\n키 : " + length + "\n몸무게 : " + weight + "\nIQ : " + IQ + "\n별명 : " + nickname +
                        "\n주민번호 : " + IDCode);
    }
}