package br.com.fa7.airplanetickets.modelo.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "passagem")
@SQLDelete(sql = "UPDATE passagem SET esta_ativo = false WHERE id = ?")
@Where(clause = "esta_ativo = '1'")
public class Passagem extends BaseModel {

	private static final long serialVersionUID = 7843226344506258083L;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_passageiro", nullable = false)
    private Passageiro passageiro;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva reserva;

    public Passagem() {
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
