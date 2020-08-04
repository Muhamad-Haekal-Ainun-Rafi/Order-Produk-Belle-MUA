package com.melenia.makeup.Model;
import java.io.Serializable;

public class Request {

    private String nama;
    private String tanggal_lahir;
    private String alamat;
    private String no_telpon;
    private String email;
    private String foto;
    private String key;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }



    public Request(){

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telpon() {
        return no_telpon;
    }

    public void setNo_telpon(String no_telpon) {
        this.no_telpon = no_telpon;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Request(String nama, String tanggal_lahir, String alamat,String no_telpon, String email, String foto) {
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
        this.alamat = alamat;
        this.no_telpon = no_telpon;
        this.email = email;
        this.foto = foto;
    }



    @Override
    public String toString(){
        return ""+nama+"\n"+
                ""+tanggal_lahir+"\n"+
                ""+alamat+"\n"+
                ""+no_telpon+"\n"+
                ""+email;
    }

}
