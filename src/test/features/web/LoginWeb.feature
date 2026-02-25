@web
Feature: Login Web Demoblaze

  Scenario: Berhasil login dengan akun valid
    Given Saya membuka halaman utama Demoblaze
    When Saya klik menu Log in
    And Saya memasukkan username "cece_keren" dan password "rahasia123"
    And Saya klik tombol Log in pada pop up
    Then Saya melihat nama akun "Welcome cece_keren" di pojok kanan atas