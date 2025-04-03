public class Gerente extends Funcionario{
    String dataIngressoCarreiraGerencia;
    AgenciaBancaria agencia;
    String possuiCursoGerencia;

    public String getDataIngressoCarreiraGerencia(){
        return this.dataIngressoCarreiraGerencia;
    }
    public AgenciaBancaria getAgenciaGerente(){
        return this.agencia;
    }
    public String getPossuiCursoGerencia(){
        return this.possuiCursoGerencia;
    }
    public void setDataIngressoCarreiraGerencia(String ingresso){
        this.dataIngressoCarreiraGerencia = ingresso;
    }
    public void setAgenciaGerente(AgenciaBancaria agencia){
        this.agencia = agencia;
    }
    public void setPossuiCursoGerencia(String possuiCurso){
        this.possuiCursoGerencia = possuiCurso;
    }
}
