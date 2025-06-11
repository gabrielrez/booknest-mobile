# 📚 BookNest

**BookNest** é uma plataforma de leitura intuitiva e prática que oferece um catálogo completo de livros para você explorar. Com ela, você pode:

- Adicionar seus títulos favoritos à sua biblioteca pessoal  
- Acompanhar o progresso das suas leituras  
- Fazer anotações e registrar ideias e insights ao longo da jornada  

---

## 🚀 Tecnologias Utilizadas

- **Backend:** PHP com [Laravel](https://laravel.com/)  
- **Mobile (Android):** Nativo com Kotlin  
- **Comunicação HTTP:** [Retrofit](https://square.github.io/retrofit/)  

---

## ⚙️ Como Rodar o Projeto

### 🔧 Backend

1. Acesse o repositório da API: [BookLy - GitHub](https://github.com/EduEdu255/BookLy)  
2. Clone a branch `dev`:  
   ```bash
   git clone -b dev https://github.com/EduEdu255/BookLy.git
   cd BookLy/booknest
   composer install
   cp .env.example .env
   php artisan key:generate
   php artisan serve

### 📱 Aplicativo Mobile

- Abra o projeto Android no Android Studio
- Obtenha um token de acesso através do endpoint de login da API
- Substitua o token atual no arquivo RetrofitClient.kt pelo seu token
- Execute o projeto no emulador ou dispositivo físico

---
