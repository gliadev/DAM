using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Camara : MonoBehaviour
{
    [Tooltip("GameObject al que debe seguir la cámara")]
    public Transform objetivo = null;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        PosicionarCamara();
    }

    private void PosicionarCamara()
    {
        if (objetivo != null)
        {
            Vector3 nuevaPosicion = objetivo.position;
            nuevaPosicion.z = this.transform.position.z;

            transform.position = nuevaPosicion;
        }
    }
}
