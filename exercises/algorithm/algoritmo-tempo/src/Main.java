public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hora_segundo("12:"));
    }

    static class Solution {
        public String hora_segundo(String hora){
            String[] partes = hora.split(":");

            if(partes.length != 3){
                return "Formato invalido. Use o formato HH:MM:SS";
            }

            long horasBrutas = 0;
            long minutosBrutos = 0;
            long segundosBrutos = 0;

            try{
                horasBrutas = Integer.parseInt(partes[0].trim());
                minutosBrutos = Integer.parseInt(partes[1].trim());
                segundosBrutos = Integer.parseInt(partes[2].trim());
            } catch (NumberFormatException nfe){
                return "Entrada invalida. Use apenas numeros no formato HH:MM:SS";
            }

            long totalSegundos = (horasBrutas * 3600) + (minutosBrutos * 60) + segundosBrutos;

            long horas = totalSegundos / 3600;
            long minutos = (totalSegundos % 3600) / 60;
            long segundos = totalSegundos % 60;

            return String.format("%02d:%02d:%02d = %ds", horas, minutos, segundos, totalSegundos);
        }
    }
}