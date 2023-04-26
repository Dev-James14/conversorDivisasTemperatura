

/**
 *
 * @author JAMES RAMIREZ
 */
public class getResultTemp {
    
    public double resltConvertTem(String from , String to,double input){
        
    double resultado = 0;
        
     switch (from) {
        case "Grados Celsius":
            switch (to) {
                case "Grados Celsius":
                    resultado = input;
                    break;
                case "Grados Fahrenheith":
                    resultado = input * 1.8 + 32;
                    break;
                case "Grados Kelvin":
                    resultado = input + 273.15;
                    break;
            }
            break;
        case "Grados Fahrenheith":
            switch (to) {
                case "Grados Celsius":
                    resultado = (input - 32) * 5 / 9;
                    break;
                case "Grados Fahrenheith":
                    resultado = input;
                    break;
                case "Grados Kelvin":
                    resultado = (input - 32) * 5 / 9 + 273.15;
                    break;
            }
            break;
        case "Grados Kelvin":
            switch (to) {
                case "Grados Celsius":
                    resultado = input - 273.15;
                    break;
                case "Grados Fahrenheith":
                    resultado = (input - 273.15) * 9/5 + 32;
                    break;
                case "Grados Kelvin":
                    resultado = input;
                    break;
            }
            break;
        default:
            resultado = input;
            break;
    }
    return resultado;
    
    
}
}
