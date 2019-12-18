/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Disciplina;
import model.Turma;

/**
 *
 * @author 631420395
 */
public class TurmaDAO {
    public static void inserir(Turma turma){
        String query = "INSERT INTO turma "
            + " (nome, codDisciplina )"
            + " VALUES ( '" + turma.getNome()           + "' , "
                     + "  " + turma.getDisciplina().getId() + " ) ";
        Conexao.executar( query );
    }
    
    public static void editar(Turma turma){
        String query = "UPDATE turma SET "
            + " nome =        '" + turma.getNome()           + "' , "
            + " codDisciplina =    " + turma.getDisciplina().getId() + "    "
            + " WHERE id = " + turma.getId();
        Conexao.executar( query );
    }
    
    public static void excluir(int idTurma){
        String query = "DELETE FROM turma "
                    + " WHERE id = " + idTurma;
        Conexao.executar( query );
    }
    
    public static List<Turma> getTurmas(){
        List<Turma> lista = new ArrayList<>();
        String query = 
            "SELECT t.id, t.nome, "
                + " d.id, d.nome "
                + " FROM turma t "
                + " INNER JOIN disciplina d "
                + " ON t.codDisciplina = d.id ";
        
        ResultSet rs = Conexao.consultar( query );
        if( rs != null){
            try {
                while ( rs.next()  ) {                    
                    Disciplina dis = new Disciplina();
                    dis.setId( rs.getInt( 3 ) );
                    dis.setNome( rs.getString( 4 ) );
                    
                    Turma turma = new Turma();
                    turma.setId( rs.getInt( 1 ) );
                    turma.setNome( rs.getString( 2 ) );
                    turma.setDisciplina( dis );
                    lista.add( turma );
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    public static Turma getTurmaById(int idTurma){
        String query = 
            "SELECT t.id, t.nome, "
                + " d.id, d.nome "
                + " FROM turma t "
                + " INNER JOIN disciplina d "
                + " ON t.codDisciplina = d.id "
                + " WHERE t.id = " + idTurma;
        
        ResultSet rs = Conexao.consultar( query );
        if( rs != null){
            try {
                rs.next();                    
                Disciplina dis = new Disciplina();
                dis.setId( rs.getInt( 3 ) );
                dis.setNome( rs.getString( 4 ) );
                Turma turma = new Turma();
                turma.setId( rs.getInt( 1 ) );
                turma.setNome( rs.getString( 2 ) );
                turma.setDisciplina( dis );
                return turma;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }
}
