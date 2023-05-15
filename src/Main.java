import java.util.Scanner;
abstract class Calculator {
    private final double[] numbers = new double[100];
    private int index = 0;
    public double[] getNumbers() {
        return numbers;
    }
    public void setNumbers(double number) {
        this.numbers[index] = number;
        index++;
    }
    protected int getIndex() {
        return index;
    }
    protected void clear() {
        index = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 0;
        }
    }
}
class BasicCalculator extends Calculator {
    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("Silakan pilih jenis operasi perhitungan");
            System.out.println("1. Pertambahan");
            System.out.println("2. Pengurangan");
            System.out.println("3. Perkalian");
            System.out.println("4. Pembagian");
            System.out.println("5. Kembali ke menu utama");
            System.out.print("Masukkan pilihan Anda (1-5): ");
            // validasi input
            while (!scanner.hasNextInt()) {
                System.out.println("Inputan Anda bukan angka bulat. Silakan masukkan pilihan Anda kembali (1-5):");
                scanner.next();
            }
            pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    add();
                    break;
                case 2:
                    subtract();
                    break;
                case 3:
                    multiply();
                    break;
                case 4:
                    divide();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Pilihan operasi perhitungan tidak valid!");
                    break;
            }
        } while (pilihan != 5);
    }
    private void getInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input number (x for finish): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("x")) {
                break;
            }
            try {
                double number = Double.parseDouble(input);
                setNumbers(number);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, silakan coba lagi.");
            }
        }
    }
    public void add() {
        getInput();
        double[] numbers = getNumbers();
        double result = numbers[0];
        System.out.print("Rincian pertambahan = " + numbers[0]);
        for (int i = 1; i < getIndex(); i++) {
            result += numbers[i];
            System.out.print(" + " + numbers[i]);
        }
        System.out.println();
        System.out.println("Hasil pertambahan = " + result);
        clear();
    }
    public void subtract() {
        getInput();
        double[] numbers = getNumbers();
        double result = numbers[0];
        System.out.print("Rincian pengurangan = " + numbers[0]);
        for (int i = 1; i < getIndex(); i++) {
            result -= numbers[i];
            System.out.print(" - " + numbers[i]);
        }
        System.out.println();
        System.out.println("Hasil pengurangan = " + result);
        clear();
    }
    public void multiply() {
        getInput();
        double[] numbers = getNumbers();
        double result = numbers[0];
        System.out.print("Rincian perkalian = " + numbers[0]);
        for (int i = 1; i < getIndex(); i++) {
            result *= numbers[i];
            System.out.print(" * " + numbers[i]);
        }
        System.out.println();
        System.out.println("Hasil perkalian = " + result);
        clear();
    }
    public void divide() {
        getInput();
        double[] numbers = getNumbers();
        double result = numbers[0];
        System.out.print("Rincian pembagian = " + numbers[0]);
        for (int i = 1; i < getIndex(); i++) {
            if (numbers[i] == 0) {
                System.out.print(" / " + numbers[i]);
                System.out.println();
                System.out.println("Hasil pembagian = Tak Terdefinisi (karena dibagi oleh angka nol)");
                        clear();
                return;
            }
            result /= numbers[i];
            System.out.print(" / " + numbers[i]);
        }
        System.out.println();
        System.out.println("Hasil pembagian = " + result);
        clear();
    }
}
class ScientificCalculator extends Calculator {
    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("Silakan pilih jenis operasi perhitungan");
            System.out.println("1. Akar Kuadrat");
            System.out.println("2. Perpangkatan");
            System.out.println("3. Faktorial");
            System.out.println("4. Kembali ke menu utama");
            System.out.print("Masukkan pilihan Anda (1-4): ");
            // validasi input
            while (!scanner.hasNextInt()) {
                System.out.println("Inputan Anda bukan angka bulat. Silakan masukkan pilihan Anda kembali (1-4):");
                scanner.next();
            }
            pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    squareRoot();
                    break;
                case 2:
                    exponentiation();
                    break;
                case 3:
                    factorial();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Pilihan operasi perhitungan tidak valid!");
                    break;
            }
        } while (pilihan != 4);
    }
    public void squareRoot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number (x for exit):");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number:");
            scanner.next();
        }
        double number = scanner.nextDouble();
        double result = Math.sqrt(number);
        System.out.println("Hasil √" + number + " = " + result);
        clear();
    }
    public void exponentiation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inputkan bilangan basis: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Input harus berupa angka. Silakan inputkan bil. basis lagi.");
                    scanner.next();
        }
        double baseNumber = scanner.nextDouble();
        System.out.println("Inputkan besarnya pangkat: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Input harus berupa angka. Silakan inputkan besarnya pangkat lagi.");
                    scanner.next();
        }
        double exponentNumber = scanner.nextDouble();
        double result = Math.pow(baseNumber, exponentNumber);
        System.out.println("Hasil " + baseNumber + "^" +
                exponentNumber + " = " + result);
        clear();
    }
    public void factorial() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inputkan satu angka yang akan difaktorialkan: ");
        double number;
        while (!scanner.hasNextDouble()) {
            System.out.println("Inputan salah, masukkan angka lagi");
                    scanner.next();
        }
        number = scanner.nextDouble();
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        System.out.println("Hasil " + number + "! = " + result);
        clear();
    }
}
class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int PilihJenisKalkulator;
        while (true) {
            System.out.println("Silakan pilih jenis kalkulator");
            System.out.println("1. Kalkulator Dasar");
            System.out.println("2. Kalkulator Ilmiah");
            System.out.println("3. Keluar Program");
            System.out.print("Masukkan pilihan Anda (1-3): ");
            // meminta pengguna untuk memasukkan bilangan bulat (integer) saja
            while (!scanner.hasNextInt()) {
                System.out.println("Inputan Anda bukan angka bulat. Silakan masukkan pilihan Anda kembali (1-3):");
                scanner.next();
            }
            PilihJenisKalkulator = scanner.nextInt();
            if (PilihJenisKalkulator == 1) {
                BasicCalculator basicCalculator = new
                        BasicCalculator();
                basicCalculator.calculate();
            } else if (PilihJenisKalkulator == 2) {
                ScientificCalculator scientificCalculator = new
                        ScientificCalculator();
                scientificCalculator.calculate();
            } else if (PilihJenisKalkulator == 3) {
                System.out.println("Terima kasih telah menggunakan kalkulator ini.");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}