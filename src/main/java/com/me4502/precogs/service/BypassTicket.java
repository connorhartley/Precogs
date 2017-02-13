/*
 * Copyright (c) 2017-2017 Me4502 (Matthew Miller)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.me4502.precogs.service;

import com.me4502.precogs.detection.DetectionType;
import org.spongepowered.api.entity.living.player.Player;

import java.util.List;

/**
 * A ticket that allows temporarily disabling detections of certain types on a player.
 *
 * <p>
 *     Through the use of a try-with-resources construct, it is possible to have this
 *     automatically disable itself after it has been finished with.
 * </p>
 *
 * <p>
 *     Failure to call the BypassTicket#close method will allow the player to bypass
 *     the detections indefinitely.
 * </p>
 */
public interface BypassTicket extends AutoCloseable {

    /**
     * Gets the {@link Player} this ticket is valid for.
     *
     * @return The player.
     */
    Player getPlayer();

    /**
     * Gets a list of the {@link DetectionType}s this ticket disabled.
     *
     * @return The detection type list.
     */
    List<DetectionType> getDetectionTypes();

    /**
     * Closes this bypass ticket, re-enabling detections.
     *
     * <p>
     *     If used in a try-with-resources block,
     *     this will be called automatically.
     * </p>
     */
    void close();
}