/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorauniversal;

import java.time.Duration;
import java.util.Optional;

/**
 *
 *
 */
public interface ICronometro {
 
    public boolean start();
    public Optional<Duration> stop();
    public boolean reset();
}
