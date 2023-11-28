# Tutorial 7
Pada sesi tutorial kali ini, kamu akan menerapkan materi yang telah kamu pelajari yaitu terkait `refactoring` dan `clean code`. Tidak hanya itu, kamu juga akan mencoba menggunakan SonarQube untuk membantumu mengidentifikasi _code smell_, serta men-_deploy_ aplikasi tersebut.

## Clean Code

Selama liburan beberapa hari kebelakang, kamu sempat ingat bahwa dulu pernah membuat suatu program untuk belajar SpringBoot. Namun ketika dilihat kembali programnya, ternyata masih berantakan dan bahkan sulit dipahami. Kalau kata orang-orang _kodenya kotor_. Maklum, waktu itu yang penting bisa jalan dulu saja, yang lainnya urusan belakangan.

Kali ini, kamu ingin membersihkan kodemu dan menghilangkan _code smell_-nya. Oleh karena itu, dilakukanlah _refactoring_ untuk memperbaiki kodemu sebelumnya. Untuk membantumu mengidentifikasi _code smell_, kamu juga mendapat rekomendasi dari teman untuk menggunakan SonarLint dan SonarQube. Kemudian, setelah programmu bebas dari _code smell_, kamu juga akan men-_deploy_-nya agar bisa digunakan secara luas.

## Spesifikasi Program

Aplikasi terdiri dari tiga fitur, yaitu:

1. Leap Year: Memeriksa apakah suatu tahun merupakan tahun kabisat.

2. Day Counter: Menghitung beberapa hari setelah atau sebelum hari tertentu.

3. Time Counter: Menghitung beberapa jam/menit setelah atau sebelum waktu tertentu.

## Deployment

Deployment aplikasi akan menggunakan Google Cloud Platform dengan memanfaatkan guideline deployment yang telah ada. Aplikasi ini tidak membutuhkan database dan diasumsikan environment development, test, dan production sama sehingga bagian `application.properties` dapat dihiraukan untuk saat ini. Meskipun demikian, kamu diharapkan dapat memahami peran `application.properties`.

Beberapa hal yang perlu diperhatikan.
- File `application.properties` dan beberapa versi environment tidak perlu dibuat.
- Terdapat `Dockerfile` yang sudah disesuaikan.
- Semua hal terkait database tidak perlu ditambahkan seperti dalam environment variables di GitLab dan Pipeline GitLab.
- Konfigurasi `.gitlab-ci.yml` dapat dilihat [disini](https://gist.github.com/mfikriharyanto/786f1ff7e89b63fdfb046f0620f4f05f) untuk melihat perbedaannya.
- Variabel `IMAGE_NAME` dan `CONTAINER_NAME` diisi dengan `tutorial-7`.

## Requirements

- [ ] _Refactor_ implementasi fitur Leap Year:
  - Penamaan variable/method/file
  - Mengurangi _long method_
  - Memastikan setiap _class_ memiliki _responsibility_ yang sesuai
  - Meningkatkan readability kode. Contoh bahan bacaan dapat dilihat [di sini](https://medium.com/swlh/return-early-pattern-3d18a41bba8) 
    dan [di sini](https://shhetri.github.io/clean-code/#/12).
  - Feel free untuk menghapus comments yang tidak penting dan tidak berkaitan dengan production code.
  
- [ ] _Refactor_ implementasi fitur Day Counter:
  - Mengurangi _long method_
  - Memastikan setiap _class_ memiliki _responsibility_ yang sesuai
  
- [ ] _Refactor_ implementasi fitur Time Counter untuk mengurangi _code duplication_

- [ ] Jalankan _test_ yang telah disediakan untuk memastikan fitur dapat berjalan sebagaimana mestinya  

- [ ] _Install_ SonarLint pada Intellij dan _setup_ SonarQube untuk memastikan tidak ada _code smell_ yang tersisa

- [ ] Mengatur integrasi CI/CD untuk tahap pengecekan SonarQube

- [ ] _Deploy_ aplikasi pada GCP

## Referensi
- [Refactoring Guru | Code Smells](https://refactoring.guru/refactoring/smells)

- [7 Golden Rules of Clean, Simple, and Maintainable Code](https://shhetri.github.io/clean-code/#/)

- [Early Return](https://medium.com/swlh/return-early-pattern-3d18a41bba8)

- [Tutorial SonarQube](https://docs.google.com/document/d/1JtZXKStP_rzHPmnU63VkKbrkQhFXO_cnyfJ0fCSh5Do/edit?usp=sharing)

- [Tutorial Deployment](https://docs.google.com/document/d/1szfibPvB9ZU50kKY7rJUQyYAe6LDfcLP_E0w3z_Pqvw/edit?usp=sharing)