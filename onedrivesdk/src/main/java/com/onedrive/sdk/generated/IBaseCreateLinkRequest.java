// ------------------------------------------------------------------------------
// Copyright (c) 2015 Microsoft Corporation
// 
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
// 
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
// ------------------------------------------------------------------------------

package com.onedrive.sdk.generated;

import com.onedrive.sdk.concurrency.ICallback;
import com.onedrive.sdk.core.ClientException;
import com.onedrive.sdk.extensions.ICreateLinkRequest;
import com.onedrive.sdk.extensions.Permission;

// **NOTE** This file was generated by a tool and any changes will be overwritten.

/**
 * The interface for the Base Create Link Request.
 */
public interface IBaseCreateLinkRequest {

    /**
     * @deprecated As of release 1.1.3, replaced by {@link #post(ICallback)}
     */
    @Deprecated
    void create(final ICallback<Permission> callback);

    /**
     * @deprecated As of release 1.1.3, replaced by {@link #post()}
     */
    @Deprecated
    Permission create() throws ClientException;

    void post(final ICallback<Permission> callback);

    Permission post() throws ClientException;

    ICreateLinkRequest select(final String value);

    ICreateLinkRequest top(final int value);

    ICreateLinkRequest expand(final String value);
}
