using System.Collections;
using System.Collections.Generic;
using UnityEngine;

 [ExecuteInEditMode]
public class Player : MonoBehaviour
{
    public float velocidad = 5;
    public GameObject disparo = null;
    Rigidbody2D rigidbody2d;

    // Start is called before the first frame update
    void Start()
    {
        rigidbody2d = GetComponent<Rigidbody2D>();
    }

    // Las llamadas están sicronizadas con el motor de físicas. Se mueve el RigidBody
    void FixedUpdate()
    {
        moverRigidBody();
    }

    // Update is called once per frame
    void Update()
    {
        // moverTransform();

        orientar();

        if (Input.GetKeyDown(KeyCode.Space))
        {
            disparar();
        }
    }

    void disparar()
    {
        GameObject projectileGameObject = Instantiate(disparo, transform.position, transform.rotation, null);
    }

    void orientar()
    {
        // Obtener la posición del ratón
        Vector3 posicionRaton = Input.mousePosition;

        // Ajustar las coordenadas del ratón en el monitor a las de la pantalla de juego
        Vector3 posicion = Camera.main.ScreenToWorldPoint(posicionRaton);
        // Debug.Log("Posicion ratón: " + posicionRaton);

        // Obtener la dirección a partir de la posición del objeto y la del ratón
        Vector2 lookDirection = posicion - transform.position;       
        // Debug.Log("Posicion: " + posicion);

        // Girar el GameObject modificando su eje Up
        this.transform.up = lookDirection;
    }

    private void moverRigidBody()
    {
        // Leemos los valores de las teclas flecha para mover el jugador
        float entradaHorizontal = Input.GetAxis("Horizontal");
        float entradaVertical = Input.GetAxis("Vertical");

        // Movemos el RigidBody en vez del transform
        Vector2 nuevaPosition;
        nuevaPosition.x = rigidbody2d.position.x + velocidad * entradaHorizontal * Time.deltaTime;
        nuevaPosition.y = rigidbody2d.position.y + velocidad * entradaVertical * Time.deltaTime;

        rigidbody2d.MovePosition(nuevaPosition);
    }
    private void moverTransform()
    {
        // Leemos los valores de las teclas flecha para mover el jugador
        float entradaHorizontal = Input.GetAxis("Horizontal");
        float entradaVertical = Input.GetAxis("Vertical");
        
        if (entradaVertical != 0)
        {
            Debug.Log("Vertical: " + entradaVertical);
        }
        if (entradaHorizontal != 0)
        {
            Debug.Log("Horizontal: " + entradaHorizontal);
        }

        /* Movemos el objeto segun la velocidad configurada y las teclas pulsadas */
        transform.Translate(Vector3.up * Time.deltaTime * velocidad * entradaVertical);
        transform.Translate(Vector3.right * Time.deltaTime * velocidad * entradaHorizontal);

        /* Movemos usando position
        float x = transform.position.x;
        float y = transform.position.y;

        x = x + Time.deltaTime * velocidad * entradaHorizontal;
        y += Time.deltaTime * velocidad * entradaVertical;

        Vector3 nuevaPosicion = new Vector3(x, y, 0);

        transform.position = nuevaPosicion;
        */
    }
}
