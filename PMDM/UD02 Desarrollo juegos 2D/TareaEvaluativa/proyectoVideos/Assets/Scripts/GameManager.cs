using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class GameManager : MonoBehaviour
{
    // Interfaz
    public Text textoVidas;
    public Text textoFin;
    public Button reiniciar;

    // Configuración
    public int numVidas = 3;

    
    // Start is called before the first frame update
    void Start()
    {
        textoFin.enabled = false;
        reiniciar.gameObject.SetActive(false);

        textoVidas.text = "Vidas: " + numVidas;
    }

    // Update is called once per frame
    void Update()
    {
    }

    public void ActualizarContador(int vidas)
    {
        textoVidas.text = "Vidas: " + vidas;
    }

    public void FinJuego()
    {
        textoFin.enabled = true;
        reiniciar.gameObject.SetActive(true);


        GameObject[] listaEnemigos = GameObject.FindGameObjectsWithTag("Enemy");
        foreach(GameObject enemigo in listaEnemigos)
        {
            Destroy(enemigo);
        }
    }
}
