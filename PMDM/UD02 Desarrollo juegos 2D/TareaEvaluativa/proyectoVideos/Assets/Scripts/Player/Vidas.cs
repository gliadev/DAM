using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Vidas : MonoBehaviour
{
    int vidas;
    GameManager gestorJuego;


    public int getVidas()
    {
        return vidas;
    }

    public void changeVidas(int cantidad)
    {
        vidas += cantidad;
        gestorJuego.ActualizarContador(vidas);
        if (vidas == 0)
        {
            Animator animator = this.GetComponent<Animator>();
            animator.SetTrigger("Muerto");
            gestorJuego.FinJuego();
            // Destroy(other.gameObject);
        }

    }

    // Start is called before the first frame update
    void Start()
    {
        gestorJuego = FindObjectOfType<GameManager>();
        vidas = gestorJuego.numVidas;
    }

    // Update is called once per frame
    void Update()
    {
    }
}
