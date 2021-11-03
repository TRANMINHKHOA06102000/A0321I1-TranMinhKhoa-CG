package model.service.common;

public class Validator {
    // static ProductRepository productRepository = new ProductRepositoryImpl();

    //    public static String validateName(String name) {
//        String message = null;
//        String regex = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$";
//        if (!name.matches(regex)) {
//            message = "Tên không đúng định dạng";
//        }
//        else if (productRepository.findByName(name) != null) {
//            message = "Tên không được trùng";
//        }
//        return message;
//    }
    public static String validatePrice(double price) {
        String message = null;
        if (price < 0) {
            message = "Giá phải là số dương";
        }
        return message;
    }
}
