public enum EnumTest {
    PAY {
        @Override
        boolean test() {
            return false;
        }
    };

    abstract boolean test();

}
