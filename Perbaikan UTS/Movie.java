public class Movie {
    int id;
    String judul;
    int tahun;
    float rating;

    Movie(int i, String j, int t, float r){
        id = i;
        judul = j;
        tahun = t;
        rating = r;
    }


    void tampil(){
        
        System.out.println("ID: "+id+"\nJudul: " +judul+"\n Tahun: "+tahun+"\n Rating: "+rating);
    }
}

class PencarianTahun {
    Movie listMovie[];
    int idx;
    
    void tambah(Movie m){
        if(idx < listMovie.length){
            listMovie[idx] = m;
            idx++;
        }else{
            System.out.println("Data sudah penuh !!");
        }
    }

    void tampil(){
        for(Movie m : listMovie){
            m.tampil();
            System.out.println("-------------------------------------------");
        }
    }
    // tambahkan algoritma pengurutan dan pencarian yang sesuai

    
    void selectionSort(){
        for(int i=0; i<listMovie.length; i++){
            int idxMin = i;
            for(int j=i+1; j<listMovie.length; j++){
                if(listMovie[j].tahun < listMovie[idxMin].tahun){
                    idxMin = j;
                }
            }
            // swap
            Movie tmp = listMovie[idxMin];
            listMovie[idxMin] = listMovie[i];
            listMovie[i] = tmp;
        }
    }

    public int FindBinarySearch(int cari, int left, int right){
        int mid;
        if(right >= left){
            mid = (left+right)/2;
            if(cari == listMovie[mid].tahun){
                return (mid);
            }else if(listMovie[mid].tahun < cari){
                return FindBinarySearch(cari, mid+1, right);    
            }else{
                return FindBinarySearch(cari, left, mid-1);
            }
        }
        return -1;
    }

    public void TampilPosisi(int x, int pos){
        if(pos != -1){
            System.out.println("data\t : "+ x + " ditemukan pada indeks "+pos+"\n");
        }else{
            System.out.println("data\t : "+ x + " tidak ditemukan");
        }
    }
    
    public void TampilData(int x, int pos){
        if(pos != -1){
            System.out.println("id\t : "+listMovie[pos].id);
            System.out.println("Judul\t : "+listMovie[pos].judul);
            System.out.println("Tahun\t : "+x);
            System.out.println("Rating\t : "+listMovie[pos].rating);
        }else{
            System.out.println("data "+x+" tidak ditemukan");
        }
    }
}