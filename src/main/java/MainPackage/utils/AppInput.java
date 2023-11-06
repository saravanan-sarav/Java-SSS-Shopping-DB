package MainPackage.utils;

public class AppInput {

    public static String enterString(String msg){
        Utils.print(msg);
        return AppScanner.getScanner().nextLine();
    }
    public static int enterInt(String msg) throws AppException {
        Utils.print(msg);
        try {
            int value = Integer.parseInt(AppScanner.getScanner().nextLine());
            return value;
        } catch (Exception e){
            throw new AppException(StringUtils.ERROR_MESSAGE);
        }
    }
    public static double enterDouble(String msg){
        Utils.print(msg);
        return AppScanner.getScanner().nextDouble();
    }
}
