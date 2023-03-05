package modelo;

public class DiaFecha {
    //Metodo que devuelve el dia de la fecha ingresada para poder poner en la agenda de cada espacio
   public static int diaDeLaSemana(int d, int m, int y) {
        int[] t = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        if (m < 3) {
            y -= 1;
        }
        int diaInt = (y + y / 4 - y / 100 + y / 400 + t[m-1] + d) % 7;
        //Transformar a String
        int diaString = switch (diaInt) {
            case 0 ->
                0;
            case 1 ->
                1;
            case 2 ->
                2;
            case 3 ->
                3;
            case 4 ->
                4;
            case 5 ->
                5;
            case 6 ->
                6;
            default ->
                -1;
        };
        return diaString;
    }
}