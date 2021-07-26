## Problem Statement
Saya memiliki tempat parkir yang dapat menampung hingga 'n' mobil pada titik waktu tertentu. Setiap slot diberi nomor mulai dari 1 yang bertambah dengan bertambahnya jarak dari titik masuk dalam langkah satu. Saya ingin membuat sistem tiket otomatis yang memungkinkan pelanggan saya menggunakan tempat parkir saya tanpa campur tangan manusia.
Ketika sebuah mobil memasuki tempat parkir saya, saya ingin memiliki tiket yang dikeluarkan untuk pengemudi. Proses penerbitan tiket termasuk kami mendokumentasikan nomor registrasi (plat nomor) dan warna mobil dan mengalokasikan slot parkir yang tersedia ke mobil sebelum benar-benar menyerahkan tiket kepada pengemudi (kami berasumsi bahwa pelanggan kami cukup baik untuk selalu parkir di slot yang dialokasikan untuk mereka). Pelanggan harus dialokasikan slot parkir yang paling dekat dengan pintu masuk. Di pintu keluar, pelanggan mengembalikan tiket yang kemudian menandai slot yang mereka gunakan sebagai tersedia.
Karena peraturan pemerintah, sistem harus memberi saya kemampuan untuk mengetahui:
* Nomor registrasi semua mobil dengan warna tertentu.
* Nomor slot di mana mobil dengan nomor registrasi tertentu diparkir.
* Nomor slot semua tempat di mana mobil dengan warna tertentu diparkir.

Kami berinteraksi dengan sistem melalui serangkaian perintah sederhana yang menghasilkan output tertentu. Silakan lihat contoh di bawah ini, yang mencakup semua perintah yang perlu Anda dukung — semuanya sudah cukup jelas. Sistem harus mengizinkan input dalam dua cara. Hanya untuk memperjelas, basis kode yang sama harus mendukung kedua mode input. kami tidak ingin dua pengajuan yang berbeda.
* Itu harus memberi kami shell berbasis command prompt interaktif di mana perintah dapat diketik
* Itu harus menerima nama file sebagai parameter pada prompt perintah dan membaca perintah dari file itu

### Expectations
* Code should be functionally correct.
* Code should be modular and readable. Clean and professional level code.
* Code should be extensible and scalable. Means it should be able to accommodate new requirements with minimal changes.
* Code should have good OOPs design.