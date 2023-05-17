 class Administrador extends Base{

    private double salario;
    private int id;

     public Administrador(String nome, int idade, String email, double salario, int id) {
         super(nome, idade, email);
         this.salario = salario;
         this.id = id;
     }


     public double getSalario() {
         return salario;
     }

     public void setSalario(double salario) {
         this.salario = salario;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }


     public void excluirUsuario(){

     }

//     metodos implementados em Base
//     implementar metodos de gerencia de filmes
 }
