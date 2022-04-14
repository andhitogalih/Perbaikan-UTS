import java.util.Scanner;

class MainMovie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan jumlah movie: ");
        int jmlM = sc.nextInt();

        PencarianTahun movie1 = new PencarianTahun();
        Movie[] movie = new Movie[jmlM];
        movie1.listMovie = movie;
        for(int i=0; i < movie.length; i++){
            
            int id = i + 1;
            System.out.println("===================");
            System.out.println("Data Movie ke-"+id);
            System.out.println("Judul: ");
            String judul = input.nextLine();
            System.out.println("Tahun: ");
            int tahun = sc.nextInt();
            System.out.println("Rating: ");
            float rating = sc.nextFloat();
            // instance movie
            Movie m = new Movie(id, judul, tahun, rating);
            movie1.tambah(m);
        }
        
        System.out.println("\nDATA SEBELUM DIOLAH");
        movie1.tampil();

        System.out.println("\nPENGURUTAN DATA");
        // terapkan fungsi pengurutan data
        movie1.selectionSort();
        movie1.tampil();

        System.out.println("\nPENCARIAN DATA");
        System.out.println("Cari Tahun :"); // isi titik-titik sesuai atribut yang diolah
        int ct = sc.nextInt(); // isi titik-titik sesuai atribut yang diolah

        System.out.println("===========================================");
        System.out.println("menggunakan binary search");
        for(int i=0; i< movie.length; i++){
           
            if(movie[i].tahun != ct){ // isi titik-titik sesuai atribut yang diolah

            } else{
                int posisi = movie1.FindBinarySearch(ct, 0, jmlM-1);
                movie1.TampilPosisi(ct, posisi);
                movie1.TampilData(ct, posisi);
            }
            
        }
    }
}
