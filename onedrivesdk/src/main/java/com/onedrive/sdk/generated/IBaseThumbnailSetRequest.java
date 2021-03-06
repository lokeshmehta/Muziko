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
import com.onedrive.sdk.extensions.ThumbnailSet;
import com.onedrive.sdk.http.IHttpRequest;

// **NOTE** This file was generated by a tool and any changes will be overwritten.

/**
 * The interface for the Base Thumbnail Set Request.
 */
public interface IBaseThumbnailSetRequest extends IHttpRequest {

    void get(final ICallback<ThumbnailSet> callback);

    ThumbnailSet get() throws ClientException;

    /**
     * @deprecated As of release 1.1.3, replaced by {@link #patch(ThumbnailSet, ICallback)}
     */
    @Deprecated
    void update(final ThumbnailSet sourceThumbnailSet, final ICallback<ThumbnailSet> callback);

    /**
     * @deprecated As of release 1.1.3, replaced by {@link #patch(ThumbnailSet)}
     */
    @Deprecated
    ThumbnailSet update(final ThumbnailSet sourceThumbnailSet) throws ClientException;

    void patch(final ThumbnailSet sourceThumbnailSet, final ICallback<ThumbnailSet> callback);

    ThumbnailSet patch(final ThumbnailSet sourceThumbnailSet) throws ClientException;

    void delete(final ICallback<Void> callback);

    void delete() throws ClientException;

    /**
     * @deprecated As of release 1.1.3, replaced by {@link #post(ThumbnailSet, ICallback)}
     */
    @Deprecated
    void create(final ThumbnailSet newThumbnailSet, final ICallback<ThumbnailSet> callback);

    /**
     * @deprecated As of release 1.1.3, replaced by {@link #post(ThumbnailSet)}
     */
    @Deprecated
    ThumbnailSet create(final ThumbnailSet newThumbnailSet) throws ClientException;

    void post(final ThumbnailSet newThumbnailSet, final ICallback<ThumbnailSet> callback);

    ThumbnailSet post(final ThumbnailSet newThumbnailSet) throws ClientException;

    IBaseThumbnailSetRequest select(final String value);

    IBaseThumbnailSetRequest top(final int value);

    IBaseThumbnailSetRequest expand(final String value);
}
