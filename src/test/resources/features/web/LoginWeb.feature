@web
Feature: Login Web Demoblaze

  Scenario: Berhasil login dengan akun valid
    Given Saya membuka halaman utama Demoblaze
    When Saya klik menu Log in
    And Saya memasukkan username "admin" dan password "admin"
    And Saya klik tombol Log in pada pop up
    Then Saya melihat nama akun "Welcome admin" di pojok kanan atas