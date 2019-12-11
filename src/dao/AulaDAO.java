/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Aula;

/**
 *
 * @author 631420395
 */
public class AulaDAO {
    public static void inserir(Aula aula){
        String data = aula.getDia().getYear() + "-" + ( aula.getDia().getMonth()+1) +
                "-" + ( aula.getDia().getDate());
        String query = "INSERT INTO aula ( nome, dia ) "
                + " VALUES ('" + aula.getNome() + "' , "
                        + " '" + data + "' ) ";
        Conexao.executar( query );
    }
    
    public static void editar(Aula aula){
        String data = aula.getDia().getYear() + "-" + ( aula.getDia().getMonth()+1) +
                                                "-" + ( aula.getDia().getDate());
        String query = "UPDATE aula SET "
                     + " nome =  '" + aula.getNome() + "' , "
                     + " dia = '" + data + "' "
                     + " WHERE id = " + aula.getId();
        Conexao.executar( query );
    }
    
    public static void excluir(int idAula){
        String query = "DELETE FROM aula  "
                     + " WHERE id = " + idAula;
        Conexao.executar( query );
    }
    
    public static List<Aula> getAulas(){
        List<Aula> lista = new ArrayList<>();
        String query = "SELECT id, nome, DATE_FORMAT(dia, '%Y') AS ano, "
                + " DATE_FORMAT(dia, '%m') AS mes, DATE_FORMAT(dia, '%d') AS dia "
                + " FROM aula ORDER BY dia";
        ResultSet rs = Conexao.consultar( query );
        
        if( rs != null ){
           
            try {
                while ( rs.next() ) {                    
                    Aula aula = new Aula();
                    aula.setId( rs.getInt( 1 ) );
                    aula.setNome( rs.getString( 2 ) );
                    Date dia = new Date(rs.getInt( 3 ), (rs.getInt( 4 )-1), rs.getInt( 5 ));
                    aula.setDia( dia );
                    lista.add(aula);
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    public static Aula getAulaById( int idAula ){
 
        String query = "SELECT id, nome, DATE_FORMAT(dia, '%Y') AS ano, "
                                     + " DATE_FORMAT(dia, '%m') AS mes, "
                                     + " DATE_FORMAT(dia, '%d') AS dia FROM aula "
                                     + " WHERE id = " + idAula;
        ResultSet rs = Conexao.consultar( query );
        if( rs != null ){
            try {
                rs.next();                   
                Aula aula = new Aula();
                aula.setId( rs.getInt( 1 ) );
                aula.setNome( rs.getString( 2 ) );
                Date dia = new Date(rs.getInt( 3 ), (rs.getInt( 4 )-1), rs.getInt( 5 ));
                aula.setDia( dia );
                return aula;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }
}
