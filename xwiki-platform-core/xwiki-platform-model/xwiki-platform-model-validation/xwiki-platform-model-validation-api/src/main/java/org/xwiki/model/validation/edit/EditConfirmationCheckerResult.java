/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.model.validation.edit;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.xwiki.rendering.block.Block;
import org.xwiki.stability.Unstable;
import org.xwiki.text.XWikiToStringBuilder;

/**
 * The result of a {@link EditConfirmationChecker}. It contains a message and a boolean indicating if the result is an
 * error ({@code true}), or a warning ({@code false}).
 *
 * @version $Id$
 * @since 15.9RC1
 */
@Unstable
public class EditConfirmationCheckerResult
{
    private final Block message;

    private final boolean isError;

    /**
     * Constructs a new object with the specified message and error status.
     *
     * @param message the message associated with the result
     * @param isError the error status of the result, error when {@code true}, warning otherwise
     */
    public EditConfirmationCheckerResult(Block message, boolean isError)
    {
        this.message = message;
        this.isError = isError;
    }

    /**
     * Returns the message associated with this result.
     *
     * @return the message associated with this result
     */
    public Block getMessage()
    {
        return this.message;
    }

    /**
     * Checks if the result is an error.
     *
     * @return {@code true} if the result is an error, {@code false} otherwise
     */
    public boolean isError()
    {
        return this.isError;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EditConfirmationCheckerResult that = (EditConfirmationCheckerResult) o;

        return new EqualsBuilder()
            .append(this.isError, that.isError)
            .append(this.message, that.message)
            .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
            .append(this.message)
            .append(this.isError)
            .toHashCode();
    }

    @Override
    public String toString()
    {
        return new XWikiToStringBuilder(this)
            .append("message", getMessage())
            .append("isError", isError())
            .toString();
    }
}
