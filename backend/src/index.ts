import 'dotenv/config';
import express from 'express';
import helmet from 'helmet';
import cors from 'cors';
import { z } from 'zod';

const app = express();
app.use(helmet());
app.use(cors({ origin: process.env.CORS_ORIGIN?.split(',') ?? false }));
app.use(express.json({ limit: '1mb' }));

app.get('/health', (_req, res) => res.json({ status: 'ok', service: 'blackx-shark-api' }));
app.get('/api/v1/catalog/categories', (_req, res) => res.json([
  { slug: 'cards', name: 'CARDS' },
  { slug: 'gift-card', name: 'GIFT CARD' },
  { slug: 'prime-8', name: 'PRIME 8' },
  { slug: 'courses', name: 'COURSES' }
]));

const orderInput = z.object({
  email: z.string().email(),
  productId: z.string().min(1),
  quantity: z.number().int().min(1).max(10)
});
app.post('/api/v1/orders/quote', (req, res) => {
  const parsed = orderInput.safeParse(req.body);
  if (!parsed.success) return res.status(400).json({ error: 'Invalid order details' });
  // Pricing and stock must be resolved from the database before enabling checkout.
  return res.status(501).json({ error: 'Catalog pricing is not configured yet; checkout is disabled.' });
});

const port = Number(process.env.PORT ?? 8080);
app.listen(port, () => console.log(`BLACKX SHARK API listening on ${port}`));
