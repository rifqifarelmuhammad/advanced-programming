# Tutorial 2
Pada sesi `tutorial-1` kemarin, kamu sudah menerapkan dua buah *design pattern*, yaitu `Strategy Pattern` dan `Observer Pattern`. Pada sesi `tutorial-2` ini, kamu akan menerapkan *design pattern* yang sudah kamu pelajari minggu ini, yaitu `Command Pattern` dan `Template Method`.

## Command Pattern
Kesuksesanmu dalam menyelesaikan permasalahan yang dihadapi oleh berbagai pelaku usaha tersebar ke penjuru negeri. Kali ini, perusahaan bioskop ternama, PT Citra Gagah Visual, memintamu untuk membuat sebuah program yang dapat mengontrol perangkat-perangkat yang ada dalam suatu teater.

### Requirements  
- Aplikasi dapat mengontrol tiga buah device yang ada di suatu teater, yaitu:
  - Pendingin ruangan
  - Layar
  - Lampu
- Mode operasi pendingin ruangan adalah **LOW**, **MEDIUM**, **HIGH**.
- Layar dapat menampilkan **iklan**, **film**, dan juga dapat **dimatikan**.
- Lampu dapat **dinyalakan** dan **dimatikan**.
- Endpoint `/cinema-admin/enable-device` digunakan untuk enable perangkat-perangkat yang ada. Perangkat yang sudah di-*enable* dapat terlihat di Control Panel.
![Enable Device Page](/Command-enable-device-page.png)
- Endpoint `/cinema-admin/control-panel` digunakan untuk mengontrol perangkat dan menampilkan riwayat penggunaannya. Perangkat yang tampil di halaman ini hanya perangkat yang sudah di-*enable* sebelumnya.
![Control Panel Page](/Command-control-panel-page.png)

### UML Diagram  
![Diagram UML Command Pattern](/Command-UML.png)

## Template Method
PT Citra Gagah Visual cukup puas dengan hasil kerjamu. Kamu kemudian direkomendasikan untuk mengerjakan sistem baru yang ingin dibuat oleh perusahaan bioskop lain, yaitu PT XIXIXI.

Bioskop PT XIXIXI menyediakan tiga jenis cinema, yaitu Reguler, Deluxe, dan Premium. Sistem yang sudah ada saat ini terbagi menjadi tiga untuk masing-masing jenis cinema tersebut. Padahal, langkah yang perlu dilakukan untuk mengoperasikan ketiganya sama saja. Oleh karena itu, kamu diminta untuk membuat satu aplikasi yang dapat mengoperasikan ketiganya melalui satu aplikasi saja.

### Requirements
- Langkah-langkah yang perlu dilakukan untuk mengoperasikan cinema adalah sebagai berikut:
  1. Menyalakan pendingin ruangan
  2. Menghidupkan lampu
  3. Menghidupkan layar
  4. Menyalakan sound system
  5. Menampilkan iklan
  6. Mematikan lampu
  7. Menampilkan film
  8. Menghidupkan lampu
  9. Mematikan sound system
  10. Mematikan layar
  11. Mematikan lampu
  12. Mematikan pendingin ruangan
- Pengaturan perangkat pada cinema Reguler adalah sebagai berikut:
  - Pendingin ruangan: **LOW**
  - Durasi iklan: **10 detik**
  - Format film: **QHD**
- Pengaturan perangkat pada cinema Deluxe adalah sebagai berikut:
  - Pendingin ruangan: **MEDIUM**
  - Durasi iklan: **3 detik**
  - Format film: **QHD**
- Pengaturan perangkat pada cinema Premium adalah sebagai berikut:
  - Pendingin ruangan: **HIGH**
  - Durasi iklan: **tidak ada iklan**
  - Format film: **UHD**
- Endpoint `/template/cinema` digunakan untuk memilih jenis cinema.
![Pick Cinema Page](/Template-pick-cinema-page.png)
- Endpoint `/template/cinema/<jenis-cinema>` digunakan untuk melihat keluaran dari aplikasi per jenis cinema.
![Running  Cinema Page](/Template-running-cinema-page.png)

### UML Diagram
![Diagram UML Template Method](/Template-UML.png)