/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Avaliacao;
import model.Turma;

/**
 *
 * @author 631420395
 */
public class AvaliacaoDAO {
    public static void inserir(Avaliacao avaliacao){
        String query = "INSERT INTO avaliacao "
            + " (nome, codTurma )"
            + " VALUES ( '" + avaliacao.getNome()           + "' , "
                     + "  " + avaliacao.getTurma().getId() + " ) ";
        Conexao.executar( query );
    }
    
    public static void editar(Avaliacao avaliacao){
        String query = "UPDATE avaliacao SET "
            + " nome =       '" + avaliacao.getNome()           + "' , "
            + " codTurma =    " + avaliacao.getTurma().getId() + "    "
            + " WHERE id =    " + avaliacao.getId();
        Conexao.executar( query );
    }
    
    public static void excluir(int idAvaliacao){
        String query = "DELETE FROM avaliacao "
                    + " WHERE id = " + idAvaliacao;
        Conexao.executar( query );
    }
    
    public static List<Avaliacao> getAvaliacaos(){
        List<Avaliacao> lista = new ArrayList<>();
        String query = 
            "SELECT a.id, a.nome, "
                + " t.id, t.nome "
                + " FROM avaliacao a "
                + " INNER JOIN turma t "
                + " ON a.codTurma = t.id ";
        
        ResultSet rs = Conexao.consultar( query );
        if( rs != null){
            try {
                while ( rs.next()  ) {                    
                    Turma tur = new Turma();
                    tur.setId( rs.getInt( 3 ) );
                    tur.setNome( rs.getString( 4 ) );
                    
                    Avaliacao avaliacao = new Avaliacao();
                    avaliacao.setId( rs.getInt( 1 ) );
                    avaliacao.setNome( rs.getString( 2 ) );
                    avaliacao.setTurma( tur );
                    lista.add( avaliacao );
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    public static Avaliacao getAvaliacaoById(int idAvaliacao){
        String query = 
            "SELECT a.id, a.nome, "
                + " t.id, t.nome "
                + " FROM avaliacao a "
                + " INNER JOIN turma t "
                + " ON a.codTurma = t.id "
                + " WHERE id = " + idAvaliacao;
        
        ResultSet rs = Conexao.consultar( query );
        if( rs != null){
            try {
                rs.next();                    
                Turma tur = new Turma();
                tur.setId( rs.getInt( 3 ) );
                tur.setNome( rs.getString( 4 ) );
                    
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setId( rs.getInt( 1 ) );
                avaliacao.setNome( rs.getString( 2 ) );
                avaliacao.setTurma( tur );
                return avaliacao;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }
}
